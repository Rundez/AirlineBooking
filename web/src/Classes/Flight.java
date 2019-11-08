package Classes;

import java.io.Serializable;

public class Flight implements Serializable {
    String arrivalTime;
    String departureTime;
    String arrivalName;
    String departureName;
    String airplaneName;
    int departureID;
    int arrivalID;
    int airplaneID;
    int flightID;
    int price;

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public void setArrivalID(int arrivalID) {
        this.arrivalID = arrivalID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public void setDepartureName(String departureName){
        this.departureName = departureName;
    }
    public String getDepartureName(){
        return departureName;
    }
    public String getArrivalName() {
        return arrivalName;
    }

    public void setArrivalName(String arrivalName){
        this.arrivalName = arrivalName;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }
}


