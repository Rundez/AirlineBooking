package Controllers;

import Classes.Flight;
import DB.AirportDAO;
import DB.FlightDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FlightController")
public class FlightController extends HttpServlet {


    FlightDAO flightDAO = null;

    public FlightController() {
         flightDAO = new FlightDAO();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action =  request.getParameter("action");


        if(action.equals("createFlight"))
            createAirport(request, response);
    }

    public void createAirport(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");

        Flight e = new Flight();
        e.setArrivalTime(arrivalTime);
        e.setDepartureTime(departureTime);

        flightDAO.save(e);

        request.setAttribute("notification", "Airport created");
        response.sendRedirect("welcome.jsp");
    }

}
