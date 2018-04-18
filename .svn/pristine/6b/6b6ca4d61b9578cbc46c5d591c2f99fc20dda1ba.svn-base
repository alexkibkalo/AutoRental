package ua.nure.kibkalo.servlets.AdminPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.kibkalo.database.DAO.Car.CarDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete-car")
public class DeleteCar extends HttpServlet{

    private static final Logger logger = LoggerFactory.getLogger(DeleteCar.class);

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");

            String model = req.getParameter("model");
            new CarDaoImpl().removeCar(model);

            logger.info("The administrator has deleted the auto " + model + ".");

            PrintWriter out = resp.getWriter();
            out.print("<h2>The operation was successfully completed!</h2>");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req, resp);
        }
}
