package contract;

import entity.AbstractEntity;
import person.Person;

import java.time.LocalDate;

public class Contract extends AbstractEntity {

    private final LocalDate startDate;
    private final LocalDate expirationDate;
    private final long number;
    private final Person owner;

    protected Contract(int id, LocalDate startDate, LocalDate expirationDate, long number, Person owner) {
        super(id);
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.number = number;
        this.owner = owner;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public long getNumber() {
        return number;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                ", start date=" + startDate +
                ", expiration date=" + expirationDate +
                ", number=" + number +
                ", owner=" + owner;
    }
}
