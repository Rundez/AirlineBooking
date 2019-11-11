package DB;

import Classes.Customer;

import java.sql.*;
import java.util.ArrayList;

import static DB.DBconnection.openConnection;

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
        while (resultSet.next()) {
            customer.setPersonID(resultSet.getInt("PersonID"));
        }

        //Returns the id associated to the username input parameter
        System.out.println(customer.getPersonID());
        return customer.getPersonID();

    }

    public int checkBalance(int userID) throws SQLException {
        String sql = "select AccountMoney from RegistrationForm where PersonID=?";

        // Executes a static method "openconnection" which connects to the DB.
        connection = DBconnection.openConnection();

        //Inserting the SQL query to the prepared statement
        preparedStatement = connection.prepareStatement(sql);

        //Parameters to be checked
        preparedStatement.setInt(1, userID);

        //Fetches data FROM the database
        resultSet = preparedStatement.executeQuery();


        Customer customer = new Customer();
        while (resultSet.next()) {
            customer.setAccountMoney(resultSet.getInt("AccountMoney"));
        }

        // Returns the current balance of the customer.
        return customer.getAccountMoney();

    }

    public void calculateMoney(int userID, int amount, int price) throws SQLException {
        int sum = amount - price;

        String sql = "UPDATE registrationForm SET AccountMoney = " + sum + " WHERE PersonID = "
                + userID;

        Connection con = openConnection();

        statement = con.createStatement();

        statement.executeUpdate(sql);
    }

    public void insertPayback(int userID, int price, int balance) throws SQLException {

        int sum = balance + price;

        String sql = "UPDATE registrationForm SET AccountMoney = " + sum + " WHERE PersonID = "
                + userID;

        Connection con = openConnection();

        statement = con.createStatement();

        statement.executeUpdate(sql);

    }

    public void updateFirstName(int userID, String firstName) throws SQLException {

        String sql =  "UPDATE RegistrationForm SET FirstName = '" +firstName + "'  WHERE PersonID = " +  userID;

        Connection con = openConnection();

        statement = con.createStatement();

        statement.executeUpdate(sql);

    }

    public void updateLastName(int userID, String lastName) throws SQLException {

        String sql =  "UPDATE RegistrationForm SET LastName = '" + lastName + "'  WHERE PersonID = " +  userID;

        Connection con = openConnection();

        statement = con.createStatement();

        statement.executeUpdate(sql);

    }

    public void updateMail(int userID, String email) throws SQLException {

        String sql =  "UPDATE RegistrationForm SET Email = '" + email + "'  WHERE PersonID = " +  userID;

        Connection con = openConnection();

        statement = con.createStatement();

        statement.executeUpdate(sql);

    }

    public void updatePassword(int userID, String password) throws SQLException {

        String sql =  "UPDATE RegistrationForm SET PasswordLogin = '" + password + "'  WHERE PersonID = " +  userID;

        Connection con = openConnection();

        statement = con.createStatement();

        statement.executeUpdate(sql);

    }

    public void updateDoB(int DoB, int userID) throws SQLException {

        String sql =  "UPDATE RegistrationForm SET DoB = '" + DoB + "'  WHERE PersonID = " +  userID;

        Connection con = openConnection();

        statement = con.createStatement();

        statement.executeUpdate(sql);

    }

    public void updatePhone(int userID, int phone) throws SQLException {

        String sql =  "UPDATE RegistrationForm SET PhoneNumber = '" + phone + "'  WHERE PersonID = " +  userID;

        Connection con = openConnection();

        statement = con.createStatement();

        statement.executeUpdate(sql);

    }
}
