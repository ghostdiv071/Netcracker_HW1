import person.Person;

import java.time.LocalDate;

public abstract class Contract {

    private final int id;
    private final LocalDate startDate;
    private final LocalDate expirationDate;
    private final long number;
    private final Person owner;

    protected Contract(int id, LocalDate startDate, LocalDate expirationDate, long number, Person owner) {
        this.id = id;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.number = number;
        this.owner = owner;
    }

    public int getId() {
        return id;
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
}
