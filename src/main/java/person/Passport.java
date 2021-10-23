package person;

public class Passport {
    private final int passportSeries;
    private final int passportId;

    public Passport(int passportSeries, int passportId) {
        this.passportSeries = passportSeries;
        this.passportId = passportId;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public int getPassportId() {
        return passportId;
    }

    @Override
    public String toString() {
        return ", passportSeries=" + passportSeries +
                ", passportId=" + passportId;
    }
}
