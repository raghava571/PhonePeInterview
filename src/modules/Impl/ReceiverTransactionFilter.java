package modules.Impl;

import models.Transaction;
import modules.TransactionFilter;

import java.util.ArrayList;
import java.util.List;

public class ReceiverTransactionFilter implements TransactionFilter {
    private String receiver;

    public ReceiverTransactionFilter(String receiver) {
        this.receiver = receiver;
    }
    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if (transaction.getReceiver().equals(this.receiver)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }
}
