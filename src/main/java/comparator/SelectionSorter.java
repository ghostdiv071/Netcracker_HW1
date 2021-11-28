package comparator;

import contract.Contract;

import java.util.Comparator;

public class SelectionSorter implements ISorter {
    @Override
    public Contract[] sort(Contract[] contracts, Comparator<Contract> comparator) {
        int length = contracts.length;
        for (int left = 0; left < length; left++) {
            int minInd = left;
            for (int i = left; i < length; i++) {
                if (comparator.compare(contracts[minInd], contracts[i]) > 0) {
                    minInd = i;
                }
            }
            Contract temp = contracts[left];
            contracts[left] = contracts[minInd];
            contracts[minInd] = temp;
        }
        return contracts;
    }
}
