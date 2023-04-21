package modules.Impl;

import models.SortCondition;
import models.Transaction;
import modules.TransactionSorter;

import java.util.Comparator;


public class DateTransactionSorter implements TransactionSorter {
    SortCondition sortCondition;
    public DateTransactionSorter(SortCondition sortCondition){
        this.sortCondition = sortCondition;
    }
    @Override
    public Comparator<Transaction> getComparator() {
        return new Comparator<Transaction>() {
            public int compare(Transaction t1, Transaction t2) {
                if(sortCondition.equals(SortCondition.INCREASING)){
                    return t1.getDate().compareTo(t2.getDate());
                } else {
                    return t2.getDate().compareTo(t1.getDate());
                }
            }
        };
    }
}
