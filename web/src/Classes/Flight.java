package Classes;

import java.io.Serializable;

public class Flight implements Serializable {
    String arrivalTime;
    String departureTime;
    int departureID;
    int arrivalID;
    int airplaneID;
    int flightID;


    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public void setArrivalID(int arrivalID) {
        this.arrivalID = arrivalID;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureID(int departureID) {
        this.departureID = departureID;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public int getArrivalID() {
        return arrivalID;
    }

    public int getDepartureID() {
        return departureID;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }
}


