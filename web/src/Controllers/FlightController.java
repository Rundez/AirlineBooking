package Controllers;

import Classes.Flight;

import DB.FlightDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet("/FlightController")
public class FlightController extends HttpServlet {


    FlightDAO flightDAO = null;

    public FlightController() {
        flightDAO = new FlightDAO();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equals("createFlight")) {
            createFlight(request, response);
        }

        if (action.equals("searchflight")) {
            try {
                searchFlights(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public void createFlight(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");

        Flight e = new Flight();
        e.setArrivalTime(arrivalTime);
        e.setDepartureTime(departureTime);

        flightDAO.save(e);

        request.setAttribute("notification", "Flight created");
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    public void searchFlights(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        String departure = request.getParameter("from");
        String arrival = request.getParameter("to");

        ArrayList<Flight> list;
        ArrayList<Flight> flightsFound = new ArrayList<>();
        list = flightDAO.getChosenFlights();

        Iterator<Flight> it = list.iterator();
        Flight object;

        while (it.hasNext()) {
            object = it.next();
            if (object.getArrivalName() == arrival && object.getDepartureName() == departure) {
                flightsFound.add(object);

            } else{
                it.remove();
            }

        }

            request.setAttribute("list", flightsFound);
            request.getRequestDispatcher("searchFlights.jsp").forward(request, response);

        }

    }


