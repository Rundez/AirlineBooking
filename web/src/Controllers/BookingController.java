package Controllers;

import Classes.Booking;
import Classes.Customer;
import Classes.Flight;
import DB.BookingDAO;
import DB.CustomerDAO;
import DB.FlightDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet("/BookingController")
public class BookingController extends HttpServlet {


    public BookingController() {

    }

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

    }


    private void book(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {


        String user = request.getParameter("userName");
        int flight = Integer.parseInt(request.getParameter("flightID"));

        CustomerDAO customerDAO = new CustomerDAO();

        //Getting the associated userID linked to the session stored name
        int userID = customerDAO.getcustomerID(user);

        BookingDAO bookingDAO = new BookingDAO();

        // Creating a new booking object to be put into the database
        Booking b = new Booking();
        b.setfID(flight);
        b.setcID(userID);

        // Save the booking object into the database
        bookingDAO.save(b);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void showMyFlights(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        System.out.println("My flights");

        FlightDAO flightDAO = new FlightDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<Flight> list = new ArrayList();
        ArrayList<Customer> customerList = new ArrayList<>();

        // Gets the session stored username and then fetches the userID for the username in the DB.
        String user = request.getParameter("username");
        int customerID = customerDAO.getcustomerID(user);

        // Gets the list of Flights which is booked to the userID for the logged in user.
        list = flightDAO.myFlights(customerID);


        request.setAttribute("list", list);
        request.getRequestDispatcher("listMyFlights.jsp").forward(request, response);

    }

}