package comparator;

import contract.Contract;

import java.util.Comparator;

public interface ISorter {
    Contract[] sort(Contract[] contracts, Comparator<Contract> comparator);
}
