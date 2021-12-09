package repository;

import comparator.ISorter;
import contract.Contract;

import java.util.*;
import java.util.function.Predicate;

/**
 * repository.Repository - container of contracts. May contains all type of it.
 */
public class Repository {

    /**
     * repository.Repository capacity, when default constructor is called
     */
    private static final int DEFAULT_CAPACITY = 8;

    /**
     * Inner array of contracts
     */
    private Contract[] contracts;

    /**
     * Actual size of repository. May differ from contracts.length
     */
    private int size = 0;

    /**
     * set of ids, in order to avoid ids repetition
     */
    private final Set<Integer> ids = new TreeSet<>();

    public Repository() {
        contracts = new Contract[DEFAULT_CAPACITY];
    }

    public Repository(int initialCapacity) {
        if (initialCapacity > 0) {
            contracts = new Contract[initialCapacity];
        } else if (initialCapacity == 0) {
            contracts = new Contract[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal capacity");
        }
    }

    /**
     * @return non-null objects from array
     */
    public Contract[] getContracts() {
        return Arrays.copyOf(contracts, size);
    }

    /**
     * @param id - id of searched contract
     * @return - required contract
     */
    public Contract getById(int id) {
        for (Contract contract : getContracts()) {
            if (contract.getId() == id) {
                return contract;
            }
        }
        throw new NoSuchElementException("No contract with id: " + id);
    }

    /**
     * @param id - id of the contract to be removed
     */
    public void deleteById(int id) {
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if (contracts[i].getId() == id) {
                flag = false;
                System.arraycopy(contracts, i + 1, contracts, i, contracts.length - i - 1);
                size--;
                break;
            }
        }
        if (flag) throw new NoSuchElementException("No contract with id: " + id);
    }

    /**
     * @param contract - contract that will be added to repository
     */
    public void add(Contract contract) {
        if (ids.stream().anyMatch(id -> id == contract.getId())) {
            throw new IllegalArgumentException("There is already a contract with such id: " + contract.getId());
        }
        if (contracts.length == size) {
            contracts = Arrays.copyOf(contracts, size * 2);
        }
        ids.add(contract.getId());
        contracts[size++] = contract;
    }

    /**
     * @param addedElems - collection of contracts that will be added
     */
    public void addAll(Collection<Contract> addedElems) {
        Contract[] contractsArray = addedElems.toArray(new Contract[0]);
        if (contracts.length - size < contractsArray.length) {
            contracts = Arrays.copyOf(contracts, contracts.length + contractsArray.length);
        }
        System.arraycopy(contractsArray, 0, contracts, size, contractsArray.length);
        size += addedElems.size();
    }

    public int size() {
        return size;
    }

    /**
     * @param criterion - search parameters
     * @return contract that fits parameters
     */
    public Contract search(Predicate<Contract> criterion) {
        return Arrays.stream(getContracts()).
                filter(criterion).
                findFirst().
                orElseThrow(() -> new NoSuchElementException(
                        "There is no element that fits the criterion"
                ));
    }

    /**
     * @param sorter     - object of one of the ISorter realization
     * @param comparator - sorting parameter
     */
    public void sort(ISorter sorter, Comparator<Contract> comparator) {
        contracts = sorter.sort(getContracts(), comparator);
    }
}
