package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Airplane;


public class AirplaneDAO {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;


    public List<Airplane> get() {

        List<Airplane> list = null;
        Airplane airplane = null;

        try {

            list = new ArrayList<Airplane>();
            String sql = "SELECT * FROM Airplane";
            connection = DBconnection.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                airplane = new Airplane();
                airplane.setAirplaneId(resultSet.getInt("AirplaneID"));
                airplane.setModel(resultSet.getString("Model"));
                airplane.setEconomySeats(resultSet.getInt("EconomySeats"));
                airplane.setBusinessSeats(resultSet.getInt("BusinessSeats"));
                list.add(airplane);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public Airplane get(int id) {
        Airplane airplane = null;
        try {
            airplane = new Airplane();
            String sql = "SELECT * FROM Airplane where AirplaneID="+id;
            connection = DBconnection.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                airplane.setAirplaneId(resultSet.getInt("AirplaneID"));
                airplane.setModel(resultSet.getString("Model"));
                airplane.setBusinessSeats(resultSet.getInt("BusinessSeats"));
                airplane.setEconomySeats(resultSet.getInt("EconomySeats"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return airplane;
    }


    public boolean save(Airplane e) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO Airplane(Model, BusinessSeats, EconomySeats)VALUES"
                    + "('"+e.getModel()+"', '"+e.getBusinessSeats()+"', '"+e.getEconomySeats()+"')";
            connection = DBconnection.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }


    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM Airplane where AirplaneID="+id;
            connection = DBconnection.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public boolean update(Airplane airplane) {
        boolean flag = false;
        try {
            String sql = "UPDATE Airplane SET Model = '"+airplane.getModel()+"', "
                    + "BusinessSeats = '"+airplane.getBusinessSeats()+"', EconomySeats = '"+airplane.getEconomySeats()+"' where id="+airplane.getId();
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
