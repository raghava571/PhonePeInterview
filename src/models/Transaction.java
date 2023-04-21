package models;


import java.util.Date;

public class Transaction {
    private String sender;
    private String receiver;
    private double amount;
    private TransactionType transactionType;
    private Date date;

    public Transaction(String sender, String receiver, double amount, Date date, TransactionType transactionType) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
    public TransactionType getTransactonType() {
        return transactionType;
    }
}