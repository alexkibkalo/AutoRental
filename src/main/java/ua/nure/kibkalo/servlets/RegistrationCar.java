package ua.nure.kibkalo.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.kibkalo.beans.User;
import ua.nure.kibkalo.database.DAO.User.UserDaoImpl;
import ua.nure.kibkalo.utils.MailServlet;
import ua.nure.kibkalo.utils.SomeActions;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/reg_car")
public class RegistrationCar extends HttpServlet{

    private static final Logger logger = LoggerFactory.getLogger(RegistrationCar.class);

    /*Метод для оплаты автомобиля взятого на прокат возвращет Integer, входящие параметры: цена автомобиля Integer,
     *имя пользователя String, функция с водителем/без водителя String,
     *количество дней на которые пользователя заказал автомобиль Integer*/
    public Integer carPayment(int price, String username, String driver, int amount_of_day) {

        int countOfUser = new SomeActions().getCountAcrossName(username);

        if(amount_of_day < 3){
            price = price * amount_of_day;
        }

        if (amount_of_day > 3 && amount_of_day <= 7) {
            price = (int) (price - price * 0.05) * amount_of_day;
        }

        if (amount_of_day > 7) {
            price = (int) (price - price * 0.1) * amount_of_day;
        }

        if (driver.equals("With driver")) {
            countOfUser = countOfUser - price - 100 * amount_of_day;
        } else
            countOfUser = countOfUser - price;

        return countOfUser;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (req.getParameter("username") != null) {
            session.setAttribute("username", req.getParameter("username"));
        }
        String username = (String) session.getAttribute("username");

        String model = req.getParameter("Model");
        Integer price = new SomeActions().getPriceAcrossModel(model);
        String functionDriver = req.getParameter("driver");
        int amount_of_day = Integer.parseInt(req.getParameter("amount_of_day"));
        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        Integer day = Integer.parseInt(req.getParameter("amount_of_day"));
        String email = req.getParameter("Email");

        String passport = req.getParameter("Passport");

        User user = new SomeActions().getUserByName(username);

        if(!user.getStatus().equals("locked")) {
            if (new SomeActions().Test(model, name, surname, day, email, passport, functionDriver) == 1) {
                Integer count_of_user = carPayment(price, username, functionDriver, amount_of_day);

                try {
                    MailServlet.sendMessageSuccessfullyRegistration(email, name, model, day);

                    if (count_of_user < 0) {
                        req.getRequestDispatcher("jsp-user/NotEnoughMoney.jsp").forward(req, resp);
                    } else {
                        new UserDaoImpl().countUpdate(count_of_user, username);
                        session.setAttribute("count", count_of_user);
                        req.getRequestDispatcher("PageCarRegistration.jsp").forward(req, resp);

                        logger.info("User " + username + " take the car " + model + ".");
                    }

                } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(null, "User not fount! Try again!");

                        logger.error("User " + username + " not take the car " + model + ".");

                        req.getRequestDispatcher("PageCarRegistration.jsp").forward(req, resp);
                    }
                } else {
                    req.getRequestDispatcher("jsp-user/FormsIsEmpty.jsp").forward(req, resp);

                    logger.error("User " + username + " not take the car " + model + ".");
                }
            }else {
               req.getRequestDispatcher("jsp-user/UserLocked.jsp").forward(req, resp);

               logger.error("User " + username + " not take the car " + model + ".");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
