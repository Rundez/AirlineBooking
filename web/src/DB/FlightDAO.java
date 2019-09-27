package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
