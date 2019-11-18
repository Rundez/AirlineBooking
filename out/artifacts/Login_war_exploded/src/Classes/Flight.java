package Classes;

import java.io.Serializable;

public class Flight implements Serializable {
    private String arrivalTime;
    private String departureTime;
    private String arrivalName;
    private String departureName;
    private String airplaneName;
    private int departureID;
    private int arrivalID;
    private int airplaneID;
    private int flightID;
    private int price;
    private int seatID;
    private int payment;
    private int baggage;

    public int getBaggage() {
        return baggage;
    }

    public void setBaggage(int baggage) {
        this.baggage = baggage;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    String seatType;
    String seatNumber;
    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

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


