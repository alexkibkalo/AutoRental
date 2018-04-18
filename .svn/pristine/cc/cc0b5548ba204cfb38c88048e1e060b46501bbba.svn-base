package ua.nure.kibkalo.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.kibkalo.database.DAO.User.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/registration.do")
public class RegistrationForm extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationForm.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String name = req.getParameter("username");
        String pass = req.getParameter("userpass");

        boolean flag = false;
        try {
            if(name.equals("") || pass.equals("")){
                printWriter.print("Login and password must not be empty!");

                logger.info("User " + name + " is not registered!");
            }else {
                flag = new UserDaoImpl().createNewUser(name, pass);

                logger.info("User " + name + " was registered!");
            }
        } catch (SQLException e) {
            e.printStackTrace();

            logger.error("User " + name + " is not registered!");
        }

        if(flag){
            req.getRequestDispatcher("jsp-user/SuccessfullyRegistrationUser.jsp").forward(req,resp);
        }else
            req.getRequestDispatcher("jsp-user/UserAlreadyExists.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
