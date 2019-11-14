package Classes;

public class Booking {

    private int cID;
    private int fID;
    private int RN;
    private int payment;
    private int seatID;
    private int baggage;

    public int getBaggage() {
        return baggage;
    }

    public void setBaggage(int baggage) {
        this.baggage = baggage;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getcID() {
        return cID;
    }

    public int getfID() {
        return fID;
    }

    public int getRN() {
        return RN;
    }

    public void setRN(int RN) {
        this.RN = RN;
    }
}

