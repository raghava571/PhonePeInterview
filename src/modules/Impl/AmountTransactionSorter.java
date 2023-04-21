package modules.Impl;

import models.SortCondition;
import models.Transaction;
import modules.TransactionSorter;

import java.util.Comparator;

public class AmountTransactionSorter implements TransactionSorter {
    SortCondition sortCondition;
    public AmountTransactionSorter(SortCondition sortCondition){
        this.sortCondition = sortCondition;
    }
    @Override
    public Comparator<Transaction> getComparator() {
        return new Comparator<Transaction>() {
            public int compare(Transaction t1, Transaction t2) {
                if(sortCondition.equals(SortCondition.INCREASING)){
                    return Double.compare(t1.getAmount(), t2.getAmount());
                } else {
                    return Double.compare(t2.getAmount(), t1.getAmount());
                }
            }
        };
    }
}
