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
import java.io.IOException;
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
        int airplaneID = Integer.parseInt(request.getParameter("airplaneID"));
        int price = Integer.parseInt(request.getParameter("price"));
        String arrival = request.getParameter("arrival");

        ArrayList<Seats> list = new ArrayList<>();

        // Generates the DAO objects
        CustomerDAO customerDAO = new CustomerDAO();
        BookingDAO bookingDAO = new BookingDAO();
        SeatDAO seatDAO = new SeatDAO();

        //Getting the associated userID linked to the session stored name.
        int userID = customerDAO.getcustomerID(user);

        // Fetches the Seat data from the database and assigns it to a list of Seats objects.
        list = seatDAO.checkSeats(seatType, airplaneID);

        // Iterates through the list and removes the objects that does not meet the requirements
        // (Type of seat and is not occupied.
        Iterator<Seats> it = list.iterator();
        while (it.hasNext()) {
            Seats y = it.next();
            if (!y.getSeatType().equals(seatType) || y.getAirplaneID() != (airplaneID) || y.getOccupied().equals("Yes")) {
                it.remove();
            }
        }

        //Chooses the index position 0 in the list, if it contains value.
        if (list.size() >= 1){
            Seats selectedSeat = list.get(0);
            int seatID = selectedSeat.getSeatID();

            if (customerDAO.checkBalance(userID) >= price) {

                // Creating a new booking object to be put into the database
                Booking b = new Booking();
                b.setfID(flight);
                b.setcID(userID);
                b.setSeatID(seatID);
                b.setPayment(price);

                // Gets the user's balance and assigns it to amount.
                // calculateMoney() will then sum up the money to be withdrawn from the user's account.
                int amount = customerDAO.checkBalance(userID);
                customerDAO.calculateMoney(userID, amount, price);
                // Save the booking object into the database and sets "Occupied" to "Yes".
                bookingDAO.save(b);
                bookingDAO.setOccupiedSeat(seatID);
            } else{
                // Forwards the user to the next view with a notification that he/she ain't got no money to fly.
                request.setAttribute("notification", "Your balance is too low to book this flight! Please enter the secret code for a refill.");
                request.getRequestDispatcher("book.jsp").forward(request, response);
            }

            //Booking completed.
            // Forwards the user to the next view with a notification that the booking is successful.
            request.setAttribute("notification", "Booking completed! Enjoy your flight to " + arrival);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            // Forwards the user to the next view with a notification that it is no available seats.
            request.setAttribute("notification", "There are currently no seats available, maybe try another type of ticket? :)");
            request.getRequestDispatcher("book.jsp").forward(request, response);
        }

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

    //TODO: Finish this
    private void cancelBooking(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int flightID = Integer.parseInt(request.getParameter("flightID"));
        String username = request.getParameter("userName");
        int seatID = Integer.parseInt(request.getParameter("seatID"));
        int price = Integer.parseInt(request.getParameter("price"));


        BookingDAO bookingDAO = new BookingDAO();
        CustomerDAO customerDAO = new CustomerDAO();


        // Uses the username as input parameter to get the userID saved in the DB.
        int userID = customerDAO.getcustomerID(username);
        int balance = customerDAO.checkBalance(userID);
        // Cancels the booking in sql using flightID number selected and the associated ID of the customer.
        bookingDAO.cancelBooking(flightID, userID);
        bookingDAO.setNotOccupiedSeat(seatID);
        customerDAO.insertPayback(userID, price, balance);

        request.setAttribute("notification", "Booking deleted");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }


}