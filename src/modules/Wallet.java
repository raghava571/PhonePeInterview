package modules;

import exceptions.InsufficientBalanceException;
import models.Transaction;
import models.TransactionType;

import java.util.List;

public interface Wallet {
    void registerUser(String name, String phoneNumber);
    public String getUser();
    void topUpWallet(double amount, String source, TransactionType transactionType) throws InsufficientBalanceException;
    double fetchBalance();
    void sendMoney(String receiver, double amount) throws InsufficientBalanceException;
    List<Transaction> getTransactions();
    List<Transaction> getTransactions(TransactionFilter filter, TransactionSorter sorter);
}

