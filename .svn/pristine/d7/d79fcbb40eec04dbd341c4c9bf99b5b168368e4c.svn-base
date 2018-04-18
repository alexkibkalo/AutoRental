package ua.nure.kibkalo.servlets.AdminPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.kibkalo.database.DAO.Car.CarDaoImpl;
import ua.nure.kibkalo.utils.SomeActions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit-car")
public class EditCar extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(EditCar.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String old_model = req.getParameter("old_model");
        Integer old_price = new SomeActions().getCarByModel(req.getParameter("old_model")).getPrice();

        String new_model = req.getParameter("new_model");
        Integer new_price = Integer.parseInt(req.getParameter("new_price"));

        new CarDaoImpl().editCar(old_model, old_price, new_model, new_price);

        logger.info("The administrator changed the car " + old_model + ".");

        out.print("<h2>The operation was successfully completed!</h2>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
