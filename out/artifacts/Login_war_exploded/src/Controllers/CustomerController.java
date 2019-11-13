package Controllers;

import DB.DatabaseHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import DB.CustomerDAO;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getParameter("action");
        if (action.equals("editFirstName"))
            editFirstName(request, response);
        if (action.equals("editLastName"))
            editLastName(request, response);
        if (action.equals("editMail"))
            editMail(request, response);
        if (action.equals("editPassword"))
            editPassword(request, response);
        if (action.equals("editDOB"))
            editDOB(request, response);
        if (action.equals("editPhone"))
            editPhone(request, response);

    }

    private void editFirstName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("FirstName");
        String username = request.getParameter("userName");
        CustomerDAO cd = new CustomerDAO();

        int personID = 0;
        try {
            personID = cd.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cd.updateFirstName(personID, firstName);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("notification", "First name updated!");
        request.getRequestDispatcher("LogoutPost").forward(request, response);

    }


    private void editLastName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String lastName = request.getParameter("LastName");
        String username = request.getParameter("userName");


        CustomerDAO cd = new CustomerDAO();

        int personID = 0;
        try {
            personID = cd.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cd.updateLastName(personID, lastName);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("notification", "Last name updated!");
        request.getRequestDispatcher("myProfile.jsp").forward(request, response);
    }


    private void editMail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("Email");
        String username = request.getParameter("userName");


        CustomerDAO cd = new CustomerDAO();

        int personID = 0;
        try {
            personID = cd.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cd.updateMail(personID, email);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("notification", "Email updated!");
        request.getRequestDispatcher("myProfile.jsp").forward(request, response);
    }


    private void editPassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String password = request.getParameter("PasswordLogin");
        String username = request.getParameter("userName");


        CustomerDAO cd = new CustomerDAO();

        int personID = 0;
        try {
            personID = cd.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cd.updatePassword(personID, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("notification", "Password updated");
        request.getRequestDispatcher("myProfile.jsp").forward(request, response);
    }


    private void editDOB(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int DoB = Integer.parseInt(request.getParameter("DoB"));
        String username = request.getParameter("userName");


        CustomerDAO cd = new CustomerDAO();

        int personID = 0;
        try {
            personID = cd.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cd.updateDoB(DoB, personID);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("notification", "Date of birth updated");
        request.getRequestDispatcher("myProfile.jsp").forward(request, response);
    }


    private void editPhone(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int phone = Integer.parseInt(request.getParameter("PhoneNumber"));
        String username = request.getParameter("userName");


        CustomerDAO cd = new CustomerDAO();

        int personID = 0;
        try {
            personID = cd.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cd.updatePhone(personID, phone);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("notification", "Phone number updated!");
        request.getRequestDispatcher("myProfile.jsp").forward(request, response);
    }

}









