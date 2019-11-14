package Classes;

import java.io.Serializable;

public class Airplane implements Serializable {
    private String model;
    private int businessSeats;
    private int economySeats;
    private int airplaneId;


    public Airplane(){};

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public void setEconomySeats(int economySeats){
        this.economySeats = economySeats;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return airplaneId;
    }

}
