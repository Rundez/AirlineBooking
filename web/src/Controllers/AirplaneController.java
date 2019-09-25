package Controllers;

import Classes.Airplane;

public class AirplaneController {

    public static Airplane createReturnAirplane(int businessSeats, int economySeats, String model){
        Airplane airplane = new Airplane();
        airplane.setBusinessSeats(businessSeats);
        airplane.setEconomySeats(economySeats);
        airplane.setModel(model);

        return airplane;
    }
}
