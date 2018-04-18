package ua.nure.kibkalo.servlets.AdminPackage;

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

@WebServlet("/add-manager")
public class AddManager extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AddManager.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String login = req.getParameter("login");
        new UserDaoImpl().addManager(login, "manager");

        logger.info("The administrator added management " + login);

        PrintWriter out = resp.getWriter();
        out.print("<h3>Manager was successfully added!</h3>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
