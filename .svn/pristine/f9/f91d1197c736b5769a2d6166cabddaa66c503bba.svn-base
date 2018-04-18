package ua.nure.kibkalo.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.kibkalo.utils.MailServlet;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/connectWithUs")
public class ConnectWithUs extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ConnectWithUs.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");

        String subject = req.getParameter("subject");
        String text = req.getParameter("text");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            MailServlet.generateAndSendEmailAdmin(subject, text, email, password);
            JOptionPane.showMessageDialog(null, "Message successfully send!");
            req.getRequestDispatcher("PageConnectWithUs.jsp").forward(req, resp);

            logger.info("User with email " + email + " send message!");

        } catch (MessagingException | ServletException e) {
            JOptionPane.showMessageDialog(null, "Error! ");
            req.getRequestDispatcher("PageConnectWithUs.jsp").forward(req, resp);

            logger.error("User with email " + email + " not send message!");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
