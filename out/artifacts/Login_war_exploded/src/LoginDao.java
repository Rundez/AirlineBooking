import java.sql.*;

public class LoginDao
{
    String sql = "select * from RegistrationForm where FirstName=? and PasswordLogin=?";
    String url = "jdbc:mysql://localhost:3306/java";
    String username = "root";
<<<<<<< HEAD
    String password = "";
=======
    String password = "gruppe14";

>>>>>>> martinsbranch
    public boolean check(String uname, String pass) throws ClassNotFoundException, SQLException {

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
}
