package Classes;

import java.io.Serializable;

public class Seats implements Serializable {
    int seatID;
    int airplaneID;
    String seatNumber;
    String seatType;

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }
}
