package Controllers;

import Classes.Booking;
import Classes.Customer;
import Classes.Flight;
import Classes.Seats;
import DB.BookingDAO;
import DB.CustomerDAO;
import DB.FlightDAO;
import DB.SeatDAO;


import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet("/BookingController")
public class BookingController extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting the parameter "action" to check for which method to call.
        String action = request.getParameter("action");

        if (action.equals("book")) {
            try {
                book(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("myFlights")) {
            try {
                showMyFlights(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("cancel")) {
            try {
                cancelBooking(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void book(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        // Gets the parameters in the request object from the view.
        String user = request.getParameter("userName");
        int flight = Integer.parseInt(request.getParameter("flightID"));
        String seatType = request.getParameter("radio");
        String airplaneID = request.getParameter("airplaneID");

        System.out.println(airplaneID);


        // Generates the DAO objects
        CustomerDAO customerDAO = new CustomerDAO();
        BookingDAO bookingDAO = new BookingDAO();
        SeatDAO seatDAO = new SeatDAO();

        //Getting the associated userID linked to the session stored name
        int userID = customerDAO.getcustomerID(user);

        // Creating a new booking object to be put into the database
        Booking b = new Booking();
        b.setfID(flight);
        b.setcID(userID);






        // Save the booking object into the database
        bookingDAO.save(b);

        // Forwards the user to the next view.
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void showMyFlights(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        FlightDAO flightDAO = new FlightDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<Flight> list = new ArrayList();
        ArrayList<Customer> customerList = new ArrayList<>();

        // Gets the session stored username and then fetches the userID for the username in the DB.
        HttpSession ses = request.getSession();
        String user = (String) ses.getAttribute("username");
        int customerID = customerDAO.getcustomerID(user);

        // Gets the list of Flights which is booked to the userID for the logged in user.
        list = flightDAO.myFlights(customerID);

        request.setAttribute("list", list);
        request.getRequestDispatcher("listMyFlights.jsp").forward(request, response);

    }

    private void cancelBooking(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int flightID = Integer.parseInt(request.getParameter("flightID"));
        String username = request.getParameter("userName");

        BookingDAO bookingDAO = new BookingDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        // Uses the username as input parameter to get the userID saved in the DB.
        int userID = customerDAO.getcustomerID(username);

        // Cancels the booking in sql using flightID number selected and the associated ID of the customer.
        bookingDAO.cancelBooking(flightID, userID);

        request.setAttribute("notification", "Booking deleted");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}