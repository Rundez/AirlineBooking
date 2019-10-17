package Controllers;

import Classes.Flight;


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

@WebServlet("/BookingController")
public class BookingController extends HttpServlet {



    public BookingController() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting the parameter "action" to check for which method to call.
        String action = request.getParameter("action");

        if (action.equals("book")) {
            book(request, response);
        }

    }


    public void book(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        String dep = request.getParameter("depName");
        String user = request.getParameter("userName");
        String flight = request.getParameter("flightID");
        out.println(dep);
        out.println(user);
        out.println(flight);


    }
}