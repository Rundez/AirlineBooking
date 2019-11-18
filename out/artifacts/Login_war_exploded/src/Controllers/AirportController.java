package Controllers;

import Classes.Airport;
import DB.AirplaneDAO;
import DB.AirportDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/AirportController")
public class AirportController extends HttpServlet {

        private AirportDAO airportDAO = null;

        private AirportController() {
            airportDAO = new AirportDAO();
        }
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String action =  request.getParameter("action");
            if(action.equals("createairport"))
                createAirport(request, response);
        }

    private void createAirport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("airportName");

        Airport e = new Airport();
        e.setAirportName(name);

        airportDAO.save(e);

        request.setAttribute("notification", "Airport created");
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
