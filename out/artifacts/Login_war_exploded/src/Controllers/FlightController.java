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
import java.io.PrintWriter;

@WebServlet("/FlightController")
public class FlightController extends HttpServlet {


    FlightDAO flightDAO = null;

    public FlightController() {
         flightDAO = new FlightDAO();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action =  request.getParameter("action");


        if(action.equals("createFlight")){
            createFlight(request, response);
        } else if (action.equals("searchFlight")){
            searchFlights(request, response);
        }

    }

    public void createFlight(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");

        Flight e = new Flight();
        e.setArrivalTime(arrivalTime);
        e.setDepartureTime(departureTime);

        flightDAO.save(e);

        request.setAttribute("notification", "Airport created");
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    public void searchFlights(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String from = request.getParameter("from");
        String to = request.getParameter("to");


    }

}
