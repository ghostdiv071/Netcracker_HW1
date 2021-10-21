package contracts;

import person.Person;

import java.time.LocalDate;

public class TelevisionContract extends Contract {
    private int channels;

    public TelevisionContract(int id, LocalDate startDate, LocalDate expirationDate, long number, Person owner, int channels) {
        super(id, startDate, expirationDate, number, owner);
        this.channels = channels;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "TelevisionContract{" +
                super.toString() +
                ", channels=" + channels +
                '}';
    }
}
