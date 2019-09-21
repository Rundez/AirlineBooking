package Classes;

import java.sql.*;

public class DatabaseHandler
{
    String url = "jdbc:mysql://localhost:3306/java";
    String username = "root";
    String password = "gruppe14";


    public boolean check(String uname, String pass) throws ClassNotFoundException, SQLException {

        String sql = "select * from RegistrationForm where FirstName=? and PasswordLogin=?";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, uname);
        st.setString(2, pass);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return true;
        }

        return false;
       }

       public void addUser(String FirstName, String LastName, String Email, String PasswordLogin, int DoB, int PhoneNumber) throws ClassNotFoundException, SQLException {

           Class.forName("com.mysql.jdbc.Driver");
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

           st.executeUpdate();

       }
}

