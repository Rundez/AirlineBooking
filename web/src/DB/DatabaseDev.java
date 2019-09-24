package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseDev {

    public static void generateUsers() throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO RegistrationForm (FirstName,LastName, Email, PasswordLogin, DOB, PhoneNumber) VALUES (?,?,?,?,?,?)";
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "";

        //Initiate connection
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);

        //Choose the input for the database
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1,"test");
        st.setString(2,"testesen");
        st.setString(3,"jule@jule.com");
        st.setString(4,"123456");
        st.setString(5,"22061993");
        st.setString(6,"91189868");


        st.executeUpdate();

    }
}

