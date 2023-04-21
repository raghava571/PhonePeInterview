package modules;

import models.Transaction;

import java.util.Comparator;

public interface TransactionSorter {
    public Comparator<Transaction> getComparator();
}

