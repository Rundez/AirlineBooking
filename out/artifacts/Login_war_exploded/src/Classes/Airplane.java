package Classes;

public class Airplane {
    String model;
    int businessSeats;
    int economySeats;

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public void setEconomySeats(int economySeats){
        this.economySeats = economySeats;
    }

    public void setModel(String model) {
        this.model = model;
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


}
