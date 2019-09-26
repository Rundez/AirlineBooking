package Classes;

public class Airplane {
    String model;
    int businessSeats;
    int economySeats;
    int airplaneId;

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
