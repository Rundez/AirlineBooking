package DB;

import Classes.Booking;

import java.sql.*;

import static DB.DBconnection.*;

public class BookingDAO {


    public boolean save(Booking e) {
        boolean flag = false;
        try {
          //  int flightID = (e.getfID());
          //  int customerID = (e.getcID());

            String sql = "INSERT INTO Booking (fID, cID) VALUES (?),(?)";

            Connection con = openConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, e.getfID());
            st.setInt(2, e.getcID());
            st.executeUpdate();

            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
