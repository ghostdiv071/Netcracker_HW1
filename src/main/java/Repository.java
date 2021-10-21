import contracts.Contract;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 */
public class Repository {
    public static final int DEFAULT_CAPACITY = 8;

    private Contract[] contracts;
    private int size = 0;

    public Repository(int initialCapacity) {
        if (initialCapacity > 0)
            contracts = new Contract[initialCapacity];
        else if (initialCapacity == 0)
            contracts = new Contract[DEFAULT_CAPACITY];
        else throw new IllegalArgumentException("Illegal capacity");
    }

    /**
     *
     *
     * @param id - id of searched contract
     * @return - required contract
     */
    public Contract getById(int id) {
        for (Contract contract : contracts) {
            if (contract.getId() == id)
                return contract;
        }
        throw new NoSuchElementException("No contract with id: " + id);
    }

    /**
     *
     * @param id - id of the contract to be removed
     */
    public void deleteById(int id) {
        boolean flag = true;
        for (Contract contract : contracts) {
            if (contract.getId() == id) {
                flag = false;
                System.arraycopy(contracts, id + 1, contracts, id, contracts.length - id - 1);
                contracts[--size] = null;
                break;
            }
        }
        if (flag) throw new NoSuchElementException("No contract with id: " + id);
    }

    /**
     *
     * @param contract - contract that will be added to repository
     */
    public void add(Contract contract) {
        if (contracts.length == size) {
            contracts = Arrays.copyOf(contracts, size * 2);
        }
        contracts[size++] = contract;
    }

    public int size() {
        return size;
    }
}
