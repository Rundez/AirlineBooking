import java.sql.*;

public class RegisterDao
{
    String sql = "select * from login where uname=? and pass=?";
    String url = "jdbc:mysql://localhost:3306/javaTest";
    String username = "root";
    String password = "siemensmobil2";
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
