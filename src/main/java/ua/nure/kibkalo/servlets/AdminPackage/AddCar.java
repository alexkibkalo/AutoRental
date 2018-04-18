package ua.nure.kibkalo.servlets.AdminPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.kibkalo.database.DAO.Car.CarDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-car")
@MultipartConfig(maxFileSize = 16177215)
public class AddCar extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AddCar.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String model = req.getParameter("model");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Double power = Double.parseDouble(req.getParameter("power"));
        Integer fc = Integer.parseInt(req.getParameter("fc"));
        String qc = req.getParameter("qc");
        Part img = req.getPart("img");

        new CarDaoImpl().addNewCar(model, price, power, fc, qc, img);

        logger.info("The administrator added a new auto " + model + ".");

        PrintWriter out = resp.getWriter();
        out.print("<h2>The operation was successfully completed!</h2>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
