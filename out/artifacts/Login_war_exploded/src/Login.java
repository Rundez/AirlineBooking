import Classes.DatabaseHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String FirstName = request.getParameter("FirstName");
        String PasswordLogin = request.getParameter("PasswordLogin");

        // Creates new login database class to check username and password.
        DatabaseHandler dao = new DatabaseHandler();
        try {
            if (dao.check(FirstName, PasswordLogin)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", FirstName);

                response.sendRedirect("welcome.jsp");
            }
            else {
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
