import Classes.Airplane;
import Classes.Airport;
import Controllers.AirplaneController;
import Controllers.AirportController;
import DB.DatabaseHandler;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/createAirplane")
public class createAirplane extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        //Gets the user session, if the user is not logged in, will then be redirected to login.
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }

        //The user is logged in, and will continue the session.
        String name =(String)session.getAttribute("username");
        session.setAttribute("username", name);

        // Assigns airName with the user input of Airport Name and creates a new airportController.
        String airplaneName = request.getParameter("airplaneName");

        // Creates a new Airport and assign the parameters with the user input.
        // The controller creates an airport and returns it to "airport" which is added to the DB by DAO.
        AirplaneController airplane = new AirplaneController();
        airplane.createReturnAirplane()
        DatabaseHandler dao = new DatabaseHandler();

        response.sendRedirect("welcome.jsp");
        try {
            dao.addAirport(airport.toString());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}