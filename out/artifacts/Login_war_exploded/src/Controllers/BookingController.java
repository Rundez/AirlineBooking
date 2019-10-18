package Controllers;

import Classes.Booking;
import Classes.Flight;
import DB.BookingDAO;
import DB.CustomerDAO;


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

    }


    public void book(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        PrintWriter out = response.getWriter();

        String user = request.getParameter("userName");
        int flight = Integer.parseInt(request.getParameter("flightID"));

        CustomerDAO customerDAO = new CustomerDAO();

        //Getting the associated userID linked to the session stored name
        int userID = customerDAO.getcustomerID(user);

        BookingDAO bookingDAO = new BookingDAO();

        // Creating a new booking object to be put into the database
        Booking e = new Booking();
        e.setfID(flight);
        e.setcID(userID);

        // Save the booking object into the database
        bookingDAO.save(e);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}