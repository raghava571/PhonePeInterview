package modules.Impl;

import models.Transaction;
import modules.TransactionFilter;

import java.util.ArrayList;
import java.util.List;

public class SenderTransactionFilter implements TransactionFilter {
    private String sender;

    public SenderTransactionFilter(String sender) {
        this.sender = sender;
    }
    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if (transaction.getSender().equals(this.sender)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }
}
