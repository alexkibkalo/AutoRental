package ua.nure.kibkalo.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.kibkalo.beans.User;
import ua.nure.kibkalo.database.DAO.User.UserDaoImpl;
import ua.nure.kibkalo.utils.SomeActions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/connectWithManager")
public class ConnectWithManager extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ConnectWithManager.class);


    /*Метод для проверки счета и оплаты поврежденного авто, входящие параметры: счет клиента Integer,
     *объект PrintWriter, имя пользователя String, сессия HttpSession*/
    private void TestStatus(int count, PrintWriter out, String username,HttpSession session){
        if (count < 0) {
            out.print("<h3>Since you could not pay the penalty, you are blocked by administrator rights!</h3>");
            new UserDaoImpl().statusUpdate("locked", username);

            logger.info("User " + username + " is blocked by administrator!");

        } else {
            new UserDaoImpl().countUpdate(count, username);
            session.setAttribute("count", count);

            logger.info("User " + username + " successfully paid!");

            out.print("<h3>Successfully paid!</h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);

        String state = req.getParameter("returnCar");
        String username = req.getParameter("username");
        int count;
        User user = new SomeActions().getUserByName(username);

        if(state != null) {
            switch (state) {
                case "Scratch on the car":
                    count = user.getCount() - 200;
                    TestStatus(count, out, username, session);
                    break;
                case "Spotlight rear/front":
                    count = user.getCount() - 500;
                    TestStatus(count, out, username, session);
                    break;
                case "Crash in the side":
                    count = user.getCount() - 1000;
                    TestStatus(count, out, username, session);
                    break;
                case "Accident":
                    count = user.getCount() - 1800;
                    TestStatus(count, out, username, session);
                    break;
                default:
                    break;
            }
        }else
            JOptionPane.showMessageDialog(null, "Value equal NULL!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
