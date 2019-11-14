package Classes;

import java.io.Serializable;

public class Seats implements Serializable {
    private int seatID;
    private int airplaneID;
    private String seatNumber;
    private String seatType;
    private String occupied;


    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getAirplaneID() {
        return airplaneID;
    }


    public String getOccupied() {
        return occupied;
    }

    public void setOccupied(String occupied) {
        this.occupied = occupied;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatType() {
        return seatType;
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
