package modules.Impl;

import Utils.Util;
import exceptions.InsufficientBalanceException;
import models.Transaction;
import models.TransactionType;
import modules.Offer;
import modules.TransactionFilter;
import modules.TransactionSorter;
import modules.Wallet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class PhonePeWallet implements Wallet {

    private final String CASHBACK_SENDER = "PhonePe";
    private String user;
    private String phoneNumber;
    private double balance;
    private List<Transaction> transactions;
    private Offer cashbackOffer;
    private Util util;

    public PhonePeWallet() {
        util = new Util();
        transactions = new ArrayList<Transaction>();
        cashbackOffer = new CashBackOfferForFirstTransaction(this);
    }

    public void registerUser(String name, String phoneNumber) {
        this.user = name;
        this.phoneNumber = phoneNumber;
    }

    public void topUpWallet(double amount, String source, TransactionType type) throws InsufficientBalanceException {
        if (util.isAmountNotValid(amount)) {
            throw new IllegalArgumentException("Amount should be greater than 0");
        }

        balance += amount;
        Transaction transaction = new Transaction(user, source, amount, new Date(), type);
        transactions.add(transaction);
        this.addCashBackToWallet(transaction);

    }

    public double fetchBalance() {
        return balance;
    }

    public void sendMoney(String receiver, double amount) throws InsufficientBalanceException {
        if (util.isAmountNotValid(amount)) {
            throw new IllegalArgumentException("Amount should be greater than 0");
        }

        if (balance < amount) {
            throw new InsufficientBalanceException("SufficientFunds Not Available");
        }

        balance -= amount;
        Transaction transaction = new Transaction(user, receiver, amount, new Date(), TransactionType.SEND);
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }
    public List<Transaction> getTransactions(TransactionFilter filter, TransactionSorter sorter) {
        List<Transaction> filteredTransactions = filter.filter(transactions);
        Collections.sort(filteredTransactions, sorter.getComparator());
        return filteredTransactions;
    }
    private void addCashBackToWallet(Transaction transaction) throws InsufficientBalanceException {
        double cashBack = cashbackOffer.getCashBack(transaction);
        if (util.isCashBackValid(cashBack)) {
            this.topUpWallet(cashBack, CASHBACK_SENDER, TransactionType.CREDITED);
        }
    }
    public String getUser(){
        return user;
    }
}