package DB;

import Classes.Booking;

import java.sql.*;

import static DB.DBconnection.*;

public class BookingDAO {


    public boolean save(Booking e) throws SQLException {
        boolean flag = false;

            String sql = "INSERT INTO Booking  ("
                    + " fID,"
                    + " cID) VALUES ("
                    + "?, ?)";

            Connection con = openConnection();
            PreparedStatement st = con.prepareStatement(sql);

            try{
            st.setInt(1, e.getfID());
            st.setInt(2, e.getcID());
            st.executeUpdate();
            st.close();

            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }
    
    // IKKE FERDIG
    public void cancelBooking(int fID, int userID) throws SQLException {
        String sql = "DELETE FROM Booking WHERE cID = "
                + userID
                + " and "
                + "fID = "
                + fID;

        Connection con = openConnection();

        Statement st = con.createStatement();

        st.executeUpdate(sql);


    }
}
