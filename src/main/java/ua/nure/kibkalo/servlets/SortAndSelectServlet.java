package ua.nure.kibkalo.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sorted-selected")
public class SortAndSelectServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(SortAndSelectServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String sort = req.getParameter("sort");

        switch (sort) {
            case "Sort by price":
                req.getRequestDispatcher("PageWithSortedByPrice.jsp").forward(req, resp);

                logger.info("List of cars sorted by price!");

                break;
            case "Sort by name":
                req.getRequestDispatcher("PageWithSortedByName.jsp").forward(req, resp);

                logger.info("List of cars sorted by name!");

                break;
            default:
                req.getRequestDispatcher("PageCarPark.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
