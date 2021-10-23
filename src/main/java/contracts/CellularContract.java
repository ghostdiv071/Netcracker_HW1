package contracts;

import person.Person;

import java.time.LocalDate;

public class CellularContract extends Contract {
    private int cellular;
    private int smsAmount;
    private int trafficSize;

    public CellularContract(int id, LocalDate startDate, LocalDate expirationDate, long number, Person owner, int cellular, int smsAmount, int trafficSize) {
        super(id, startDate, expirationDate, number, owner);
        this.cellular = cellular;
        this.smsAmount = smsAmount;
        this.trafficSize = trafficSize;
    }

    public int getCellular() {
        return cellular;
    }

    public void setCellular(int cellular) {
        this.cellular = cellular;
    }

    public int getSmsAmount() {
        return smsAmount;
    }

    public void setSmsAmount(int smsAmount) {
        this.smsAmount = smsAmount;
    }

    public int getTrafficSize() {
        return trafficSize;
    }

    public void setTrafficSize(int trafficSize) {
        this.trafficSize = trafficSize;
    }

    @Override
    public String toString() {
        return "CellularContract{" +
                super.toString() +
                ", cellular=" + cellular +
                ", sms amount=" + smsAmount +
                ", traffic size=" + trafficSize +
                '}';
    }
}
