package Classes;

public class Booking {

    int cID;
    int fID;
    int RN;
    int payment;
    int seatID;

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

