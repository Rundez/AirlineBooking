package Controllers;

import Classes.Airport;

public class AirportController {
    private Airport model;

    public void setAirportName(){

    }

    public static Airport createReturnAirport(String airportname){
        Airport airport = new Airport();
        airport.setAirportName(airportname);

        return airport;
    }
}
