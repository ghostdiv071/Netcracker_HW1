package contract;

import entity.AbstractEntity;
import person.Person;

import java.time.LocalDate;

public class Contract extends AbstractEntity {

    private LocalDate startDate;
    private LocalDate expirationDate;
    private long number;
    private Person owner;

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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
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
