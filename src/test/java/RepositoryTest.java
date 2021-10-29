import contracts.CellularContract;
import contracts.Contract;
import contracts.InternetContract;
import contracts.TelevisionContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import person.Gender;
import person.Passport;
import person.Person;
import repository.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepositoryTest {
    private Repository repository;
    private final Person person = getPerson();

    @BeforeEach
    void init() {
        repository = new Repository();
    }

    /**
     * adding one contract
     */
    @Test
    public void add() {
        Contract contract = createCellular(1);
        repository.add(contract);
        assertEquals(contract, repository.getContracts()[0]);
    }

    /**
     * adding contracts of different types
     */
    @Test
    public void addDifferentContracts() {
        Contract tv = createTV(1);
        Contract cellular = createCellular(2);
        Contract internet = createInternet(3);
        repository.add(tv);
        repository.add(cellular);
        repository.add(internet);
        assertEquals(tv, repository.getContracts()[0]);
        assertEquals(cellular, repository.getContracts()[1]);
        assertEquals(internet, repository.getContracts()[2]);
    }

    /**
     * adding contract with existing id
     */
    @Test
    public void addExistedIdException() {
        Contract contract1 = createCellular(1);
        Contract contract2 = createTV(1);
        repository.add(contract1);
        assertThrows(IllegalArgumentException.class, () -> repository.add(contract2));
    }

    /**
     * getting contract by id
     */
    @Test
    public void getById() {
        Contract contract = createInternet(1);
        repository.add(contract);
        assertEquals(contract, repository.getById(1));
    }

    /**
     * getting non-existent contract
     */
    @Test
    public void getNullContract() {
        Contract contract = createCellular(1);
        repository.add(contract);
        assertThrows(NoSuchElementException.class, () -> repository.getById(2));
    }

    /**
     * delete contract by id
     */
    @Test
    public void delete() {
        Contract contract = createCellular(1);
        repository.add(contract);
        repository.deleteById(1);
        assertThrows(NoSuchElementException.class, () -> repository.getById(1));
    }

    /**
     * delete non-existent contract
     */
    @Test
    public void deleteNullContract() {
        Contract contract = createCellular(1);
        repository.add(contract);
        assertThrows(NoSuchElementException.class, () -> repository.deleteById(2));
    }

    /**
     * adding a collection of contracts
     */
    @Test
    public void addCollection() {
        Contract internet = createInternet(1);
        Contract cellular = createCellular(2);
        Contract tv = createTV(3);
        List<Contract> contracts = Arrays.asList(internet, cellular, tv);
        repository.addAll(contracts);
        assertEquals(internet, repository.getById(1));
        assertEquals(cellular, repository.getById(2));
        assertEquals(tv, repository.getById(3));
    }

    private Person getPerson() {
        return new Person(1,
                "Ivanov",
                "Ivan",
                "Ivanovich",
                LocalDate.of(2000, 2, 1),
                Gender.MALE,
                new Passport(1234, 123456));
    }

    private Contract createCellular(int id) {
        return new CellularContract(id,
                LocalDate.of(2020, 2, 1),
                LocalDate.of(2023, 5, 2),
                1,
                person,
                200,
                200,
                200);
    }

    private Contract createTV(int id) {
        return new TelevisionContract(id,
                LocalDate.of(2022, 2, 1),
                LocalDate.of(2023, 5, 2),
                14,
                person,
                15);
    }

    private Contract createInternet(int id) {
        return new InternetContract(id,
                LocalDate.of(2022, 2, 1),
                LocalDate.of(2023, 5, 2),
                14,
                person,
                100);
    }
}
