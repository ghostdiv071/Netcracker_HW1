package contract;

import person.Person;

import java.time.LocalDate;

public class InternetContract extends Contract {
    private int connectionSpeed;

    public InternetContract(int id, LocalDate startDate, LocalDate expirationDate, long number, Person owner, int connectionSpeed) {
        super(id, startDate, expirationDate, number, owner);
        this.connectionSpeed = connectionSpeed;
    }

    public int getConnectionSpeed() {
        return connectionSpeed;
    }

    public void setConnectionSpeed(int connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }

    @Override
    public String toString() {
        return "InternetContract{" +
                super.toString() +
                ", connection speed=" + connectionSpeed +
                '}';
    }
}
