package Controllers;

import Classes.Flight;

public class FlightController {
    private Flight flight = new Flight();

    public Flight createReturnFlight(){
        return flight;
    }

    public void setArrivalTime(String arrivalTime){
        flight.setArrivalTime(arrivalTime);
    }

    public void setDepartureTime(String departureTime){
        flight.setDepartureTime(departureTime);
    }

    public void setAirplaneID(int airplaneID){
        flight.setAirplaneID(airplaneID);
    }

    public void setDestinationID(int destinationID){
        flight.setDepartureID(destinationID);
    }

    public void setArrivalID(int arrivalID){
        flight.setArrivalID(arrivalID);
    }

}
