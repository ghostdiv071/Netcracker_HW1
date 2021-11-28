package comparator;

import contract.Contract;

import java.util.Comparator;

public class InsertionSorter implements ISorter {
    @Override
    public Contract[] sort(Contract[] contracts, Comparator<Contract> comparator) {
        for (int left = 0; left < contracts.length; left++) {
            Contract value = contracts[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (comparator.compare(contracts[i], value) > 0) {
                    contracts[i + 1] = contracts[i];
                } else {
                    break;
                }
            }
            contracts[i + 1] = value;
        }
        return contracts;
    }
}
