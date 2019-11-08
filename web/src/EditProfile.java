import DB.DatabaseHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import DB.CustomerDAO;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Getting parameters
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String Email = request.getParameter("Email");
        String PasswordLogin = request.getParameter("PasswordLogin");
        int DoB = Integer.parseInt(request.getParameter("DoB"));
        int PhoneNumber = Integer.parseInt(request.getParameter("PhoneNumber"));
        String username = request.getParameter("username");

        CustomerDAO cd = new CustomerDAO();
        int personID = 0;
        try {
            personID = cd.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            DatabaseHandler db = new DatabaseHandler();
            db.editUser(FirstName, LastName, Email, PasswordLogin, DoB, PhoneNumber, personID);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");

    }
}


