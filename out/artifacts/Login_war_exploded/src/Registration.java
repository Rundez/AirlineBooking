import Classes.DatabaseHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
    String sql = "INSERT INTO RegistrationForm (FirstName, LastName, Email, PasswordLogin, DoB, PhoneNumber) VALUES (?,?,?,?,?,?)";
    String url = "jdbc:mysql://localhost:3306/java";
    String username = "root";
    String password = "gruppe14";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Getting parameters
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String Email = request.getParameter("Email");
        String PasswordLogin = request.getParameter("PasswordLogin");
        int DoB = Integer.parseInt(request.getParameter("DoB"));
        int PhoneNumber = Integer.parseInt(request.getParameter("PhoneNumber"));


        try {
            DatabaseHandler db = new DatabaseHandler();
            db.addUser(FirstName, LastName, Email, PasswordLogin, DoB, PhoneNumber);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");

    }
}


