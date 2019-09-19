import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
    String sql = "INSERT INTO login (uname, pass) VALUES (?,?)";
    String url = "jdbc:mysql://localhost:3306/javaTest";
    String username = "root";
    String password = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Getting parameters
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        try {
            //Initialize the DB
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            //Choose the input for the database
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2,pass);

            st.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");

    }
}


