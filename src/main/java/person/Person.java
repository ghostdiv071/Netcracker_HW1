package person;

import entity.AbstractEntity;

import java.time.LocalDate;
import java.time.Period;

public final class Person extends AbstractEntity {

    private String fullName;
    private LocalDate birthday;
    private Gender gender;
    private int passportSeries;
    private int passportId;
    private int age;

    public Person() {
    }

    public Person(int id, String fullName, LocalDate birthday, Gender gender, int passportSeries, int passportId) {
        super(id);
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.passportSeries = passportSeries;
        this.passportId = passportId;
        setAge();
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public int getPassportId() {
        return passportId;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        age = Period.between(birthday, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", full name=" + fullName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender.getValue() +
                ", passport series=" + passportSeries +
                ", passport id=" + passportId +
                ", age=" + age +
                '}';
    }

    public static class Builder {
        private final Person person;

        public Builder() {
            person = new Person();
        }

        public Builder setId(int id) {
            person.setId(id);
            return this;
        }

        public Builder setFullName(String fullName) {
            person.fullName = fullName;
            return this;
        }

        public Builder setBirthday(LocalDate birthday) {
            person.birthday = birthday;
            return this;
        }

        public Builder setGender(Gender gender) {
            person.gender = gender;
            return this;
        }

        public Builder setPassportSeries(int passportSeries) {
            person.passportSeries = passportSeries;
            return this;
        }

        public Builder setPassportId(int passportId) {
            person.passportId = passportId;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}
