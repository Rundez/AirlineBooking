package Controllers;

import Classes.Flight;

import DB.FlightDAO;
import org.jetbrains.annotations.NotNull;

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
        //Fetches the airports and the departure time where the user wants to travel from and to.
        String departure = request.getParameter("from");
        String arrival = request.getParameter("to");
        String departureTimeInput = request.getParameter("datepicker");


        // Generates a list for the information and creation of Flight objects which holds the information
        // about flights.
        ArrayList<Flight> list;
        list = flightDAO.getChosenFlights();


        Iterator<Flight> it = list.iterator();

        // Filtrates the ArrayList of flight objects. If the current flight object does not contain
        // the selected airports and departure time, the object will be deleted from the list.
        while (it.hasNext()) {
            Flight y = it.next();
            // makes a new variable from fight departure time that can be compared to the date input from the user
            String s = y.getDepartureTime();
            String DepartureTimeShort = s.substring(0, s.length() - 11);
            //Removes flights that has one or more variables that dont match with input
            if (!y.getArrivalName().equals(arrival) || !y.getDepartureName().equals(departure)
                    || !DepartureTimeShort.equals(departureTimeInput)){
                it.remove();
            }
        }
            // Sends the filtered ArrayList of flights to the next page.
            request.setAttribute("from", departure);
            request.setAttribute("to", arrival);
            request.setAttribute("list", list);
            request.getRequestDispatcher("searchFlights.jsp").forward(request, response);

        }

    }


