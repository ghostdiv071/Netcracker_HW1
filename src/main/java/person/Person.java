package person;

import entity.AbstractEntity;

import java.time.LocalDate;
import java.time.Period;

public final class Person extends AbstractEntity {

    private String surname;
    private String name;
    private String patronymic;
    private final LocalDate birthday;
    private final Gender gender;
    Passport passport;
    private int age;

    public Person(int id, String surname, String name, String patronymic, LocalDate birthday, Gender gender, Passport passport) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.gender = gender;
        this.passport = passport;
        setAge();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
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
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender.getValue() +
                passport.toString() +
                ", age=" + age +
                '}';
    }
}
