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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public ArrayList<Flight> getFlights() throws SQLException {
        Flight flight = null;
        ArrayList<Flight> list = new ArrayList<>();

        String sql = "select * from java.Flight";

        connection = DBconnection.openConnection();
        statement = connection.createStatement();

        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
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

    public ArrayList<Flight> getChosenFlights() throws SQLException {
        Flight flight = null;


        ArrayList<Flight> list = new ArrayList<>();

        String sql = "SELECT  f.FlightID  , f.DepartureID ,de.AirportName Departure, DepartureTime, f.ArrivalID, ar.AirportName Arrival, ArrivalTime, a.AirplaneID, a.Model Airplane\n" +
                "FROM    flight f\n" +
                "            JOIN    airport de\n" +
                "                    ON      de.AirportID = f.DepartureID\n" +
                "            JOIN    airport ar\n" +
                "                    ON      ar.AirportID = f.ArrivalID\n" +
                "            JOIN    airplane a\n" +
                "                    ON f.AirplaneID = a.AirplaneID" +
                " order by DepartureTime";

        connection = DBconnection.openConnection();
        statement = connection.createStatement();

        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            flight = new Flight();
            flight.setDepartureTime(resultSet.getString("DepartureTime"));
            flight.setArrivalTime(resultSet.getString("ArrivalTime"));
            flight.setArrivalID(resultSet.getInt("ArrivalID"));
            flight.setDepartureID(resultSet.getInt("DepartureID"));
            flight.setAirplaneID(resultSet.getInt("AirplaneID"));
            flight.setFlightID(resultSet.getInt("FlightID"));
            flight.setArrivalName(resultSet.getString("Arrival"));
            flight.setDepartureName(resultSet.getString("Departure"));
            flight.setAirplaneName(resultSet.getString("Airplane"));
            list.add(flight);
        }
        statement.close();
        return list;
    }

    public ArrayList<Flight> myFlights(int userID) throws SQLException {
        Flight flight = null;


        ArrayList<Flight> list = new ArrayList<>();

        String sql = "SELECT  f.FlightID  , f.DepartureID ,de.AirportName Departure, DepartureTime, f.ArrivalID, ar.AirportName Arrival, ArrivalTime, a.AirplaneID, a.Model Airplane, Booking.cID \n" +
                "                FROM    flight f\n" +
                "                            JOIN    airport de\n" +
                "                                    ON      de.AirportID = f.DepartureID\n" +
                "                            JOIN    airport ar\n" +
                "                                   ON      ar.AirportID = f.ArrivalID\n" +
                "                            JOIN    airplane a\n" +
                "                                    ON f.AirplaneID = a.AirplaneID\n" +
                "                           Join Booking\n" +
                "                           ON FlightID = Booking.fID\n" +
                "                           where Booking.cID = " + userID;

        connection = DBconnection.openConnection();
        statement = connection.createStatement();

        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            flight = new Flight();
            flight.setDepartureTime(resultSet.getString("DepartureTime"));
            flight.setArrivalTime(resultSet.getString("ArrivalTime"));
            flight.setArrivalID(resultSet.getInt("ArrivalID"));
            flight.setDepartureID(resultSet.getInt("DepartureID"));
            flight.setAirplaneID(resultSet.getInt("AirplaneID"));
            flight.setFlightID(resultSet.getInt("FlightID"));
            flight.setArrivalName(resultSet.getString("Arrival"));
            flight.setDepartureName(resultSet.getString("Departure"));
            flight.setAirplaneName(resultSet.getString("Airplane"));
            list.add(flight);
        }
        statement.close();
        return list;

    }
}

