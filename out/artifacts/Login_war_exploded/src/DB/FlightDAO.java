package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Classes.Flight;


public class FlightDAO {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;



    public boolean save(Flight e) {
        boolean flag = false;
        try {
            String arrivalTime = e.getArrivalTime();
            String departureTime = e.getDepartureTime();

            String sql = "INSERT INTO Flight (ArrivalTime, DepartureTime) VALUES (?,?)";

            Connection con = DBconnection.openConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, arrivalTime);
            st.setString(2, departureTime);
            st.executeUpdate();


            flag = true;
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public ArrayList<Flight> getFlights() throws SQLException {
        Flight flight = null;
        ArrayList<Flight> list = new ArrayList<>();

        String sql =  "select * from java.Flight";

        connection = DBconnection.openConnection();
        statement = connection.createStatement();

        resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            flight = new Flight();
            flight.setDepartureTime(resultSet.getString("DepartureTime"));
            flight.setArrivalTime(resultSet.getString("ArrivalTime"));
            flight.setArrivalID(resultSet.getInt("ArrivalID"));
            flight.setDepartureID(resultSet.getInt("DepartureID"));
            flight.setAirplaneID(resultSet.getInt("AirplaneID"));
            flight.setFlightID(resultSet.getInt("FlightID"));
            list.add(flight);
        }
        statement.close();
        return list;
    }

    }


