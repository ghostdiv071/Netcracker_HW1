package comparator;

import contract.Contract;

import java.util.Comparator;

public class BubbleSorter implements ISorter {
    @Override
    public Contract[] sort(Contract[] contracts, Comparator<Contract> comparator) {
        int length = contracts.length;
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (comparator.compare(contracts[j], contracts[j + 1]) > 0) {
                    Contract temp = contracts[j];
                    contracts[j] = contracts[j + 1];
                    contracts[j + 1] = temp;
                }
        return contracts;
    }
}
