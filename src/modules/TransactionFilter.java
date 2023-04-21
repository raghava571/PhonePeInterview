package modules;

import models.Transaction;

import java.util.List;

public interface TransactionFilter {
    public List<Transaction> filter(List<Transaction> transactions);
}