package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Airplane;
import Classes.Airport;


public class AirportDAO {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;


    public List<Airport> get() {

        List<Airport> list = null;
        Airport airport = null;

        try {

            list = new ArrayList<Airport>();
            String sql = "SELECT * FROM Airport";
            connection = DBconnection.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                airport = new Airport();
                airport.setID(resultSet.getInt("AirportID"));
                airport.setAirportName(resultSet.getString("AirportName"));
                list.add(airport);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public Airport get(int id) {
        Airport airport = null;
        try {
            airport = new Airport();
            String sql = "SELECT * FROM Airport where AirportID="+id;
            connection = DBconnection.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                airport.setID(resultSet.getInt("AirportID"));
                airport.setAirportName(resultSet.getString("AirportName"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return airport;
    }


    public boolean save(Airport e) {
        boolean flag = false;
        try {
            String airportName = e.getAirportName();
            String sql = "INSERT INTO Airport (AirportName) VALUES (?)";

            Connection con = DBconnection.openConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, airportName);
            st.executeUpdate();

            flag = true;
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }


    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM Airport where AirportID="+id;
            connection = DBconnection.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public boolean update(Airport airport) {
        boolean flag = false;
        try {
            String sql = "UPDATE Airport SET AirportName = '"+airport.getAirportName() +"' where id="+airport.getId();
            connection = DBconnection.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
