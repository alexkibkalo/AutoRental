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

@WebServlet("/block-user")
public class BlockUser extends HttpServlet{

    private static final Logger logger = LoggerFactory.getLogger(BlockUser.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        new UserDaoImpl().statusUpdate("locked", username);

        logger.info("The administrator has blocked the user " + username + ".");

        PrintWriter out = resp.getWriter();
        out.print("<h2>The operation was successfully completed!</h2>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}