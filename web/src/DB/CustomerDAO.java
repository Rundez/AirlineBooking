package DB;

import Classes.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    public int getcustomerID(String username) throws SQLException {

        String sql = "select * from RegistrationForm where FirstName=?";

        // Executes a static method "openconnection" which connects to the DB.
        connection = DBconnection.openConnection();

        //Inserting the SQL query to the prepared statement
        preparedStatement = connection.prepareStatement(sql);

        //Parameters to be checked
        preparedStatement.setString(1, username);

        //Fetches data FROM the database
        resultSet = preparedStatement.executeQuery();


        Customer customer = new Customer();
        while(resultSet.next()) {
            customer.setPersonID(resultSet.getInt("PersonID"));
        }

        //Returns the id associated to the username input parameter
        System.out.println(customer.getPersonID());
        return customer.getPersonID();

    }
}
