package Classes;

public class Airport {
    String airportName;
    int id;

    public void setAirportName(String airportName){
        this.airportName = airportName;
    }

    public String getAirportName(){
        return airportName;
    }

    public void setID(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return airportName;
    }
}

