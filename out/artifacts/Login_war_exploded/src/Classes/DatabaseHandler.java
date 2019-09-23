package Classes;

import java.sql.*;

public class DatabaseHandler
{
    String url = "jdbc:mysql://localhost:3306/java";
    String username = "root";
    String password = "";
    String driver = "com.mysql.jdbc.Driver";

    // This method checks the username and password with the database.
    public boolean check(String uname, String pass) throws ClassNotFoundException, SQLException {
        //SQL query
        String sql = "select * from RegistrationForm where FirstName=? and PasswordLogin=?";

        //Initiate DB driver
        Class.forName(driver);
        //Getting Database connection
        Connection con = DriverManager.getConnection(url, username, password);
        //Inserting the SQL query to the prepared statement
        PreparedStatement st = con.prepareStatement(sql);

        //Parameters to be checked
        st.setString(1, uname);
        st.setString(2, pass);

        //Fetches data FROM the database
        ResultSet rs = st.executeQuery();
        return rs.next();
    }

       public void addUser(String FirstName, String LastName, String Email, String PasswordLogin, int DoB, int PhoneNumber) throws ClassNotFoundException, SQLException {

           Class.forName(driver);
           Connection con = DriverManager.getConnection(url, username, password);
           String sql = "INSERT INTO RegistrationForm (FirstName, LastName, Email, PasswordLogin, DoB, PhoneNumber) VALUES (?,?,?,?,?,?)";
           //Choose the input for the database
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, FirstName);
           st.setString(2, LastName);
           st.setString(3, Email);
           st.setString(4, PasswordLogin);
           st.setInt(5, DoB);
           st.setInt(6, PhoneNumber);

           //Puts data INTO the database
           st.executeUpdate();

       }
}

