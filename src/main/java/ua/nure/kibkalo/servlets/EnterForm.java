package ua.nure.kibkalo.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.kibkalo.beans.User;
import ua.nure.kibkalo.database.DAO.User.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/enter")
public class EnterForm extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(EnterForm.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("username");
        String pass = req.getParameter("userpass");

        User foundUserInDB = new UserDaoImpl().checkUserConnection(name);

        if (foundUserInDB != null) {
            if(!foundUserInDB.getStatus().equals("locked")) {
                if (foundUserInDB.getPassword().equals(pass)) {
                    req.setAttribute("login", foundUserInDB.getUsername());
                    req.setAttribute("password", foundUserInDB.getPassword());

                    if (name.equals("admin") && pass.equals("admin")) {
                        req.getRequestDispatcher("jsp-admin/PageAdmin.jsp").forward(req, resp);
                        logger.info("User " + name + " enter on page of administrator!");
                    }
                    req.getRequestDispatcher("PageCarPark.jsp").forward(req, resp);
                    logger.info("User " + name + " enter on page!");

                } else {
                    logger.info("User " + name + " not enter on page!");
                    req.getRequestDispatcher("jsp-user/UserNotAuthorized.jsp").forward(req, resp);
                }
            }else {
                logger.info("User " + name + " not enter on page!");
                req.getRequestDispatcher("jsp-user/UserLocked.jsp").forward(req, resp);
            }
        } else {
            logger.info("User " + name + " not enter on page!");
            req.getRequestDispatcher("jsp-user/UserNotAuthorized.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
