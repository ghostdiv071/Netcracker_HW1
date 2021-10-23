import contracts.Contract;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 *
 */
public class Repository {
    private static final int DEFAULT_CAPACITY = 8;

    private Contract[] contracts;
    private int size = 0;

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
        for (Contract c : getContracts()) {
            if (c.getId() == contract.getId()) {
                throw new IllegalArgumentException("There is already a contract with such id: " + contract.getId());
            }
        }
        if (contracts.length == size) {
            contracts = Arrays.copyOf(contracts, size * 2);
        }
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
}
