package DB;

import Classes.Booking;

import java.sql.*;

public class BookingDAO {
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement statement = null;


    public boolean save(Booking e) {
        boolean flag = false;
        try {
            int flightID = (e.getfID());
            int customerID = (e.getcID());

            String sql = "INSERT INTO java.Booking (fID, cID) VALUES (?),(?)";

            Connection con = DBconnection.openConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, flightID);
            st.setInt(2, customerID);
            st.executeUpdate();

            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
