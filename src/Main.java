import exceptions.InsufficientBalanceException;
import models.SortCondition;
import models.Transaction;
import models.TransactionType;
import modules.Impl.CashBackOfferForFirstTransaction;
import modules.Impl.DateTransactionSorter;
import modules.Impl.PhonePeWallet;
import modules.Impl.SenderTransactionFilter;
import modules.Offer;
import modules.TransactionFilter;
import modules.TransactionSorter;
import modules.Wallet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Wallet wallet = new PhonePeWallet();
        Offer offer = new CashBackOfferForFirstTransaction(wallet);
        wallet.registerUser("Raghav", "9329329233");

        try {
            //Recharge the wallet
            wallet.topUpWallet(1000, "Credit Card", TransactionType.ADDED);
            wallet.topUpWallet(500, "UPI", TransactionType.ADDED);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        //Fetch the balance
        System.out.println("Balance: " + wallet.fetchBalance());

        // send money to another user
        try {
            wallet.sendMoney("Pavan", 200);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        TransactionFilter transactionFilter = new SenderTransactionFilter("Raghav");
        TransactionSorter sorter = new DateTransactionSorter(SortCondition.INCREASING);
        List<Transaction> transactions = wallet.getTransactions(transactionFilter, sorter);
        for (Transaction transaction : transactions) {
            if(transaction.getTransactonType().equals(TransactionType.ADDED)){
                System.out.println(transaction.getSender() + " Added " + transaction.getAmount() + " from " + transaction.getReceiver());
            } else if(transaction.getTransactonType().equals(TransactionType.SEND) ||transaction.getTransactonType().equals(TransactionType.RECEIVED) ){
                System.out.println(transaction.getSender() + " send " + transaction.getAmount() + " to " + transaction.getReceiver());
            } else if(transaction.getTransactonType().equals(TransactionType.CREDITED)){
                System.out.println(transaction.getSender() + " Added " + transaction.getAmount() + " as Cash Back by " + transaction.getReceiver());
            }

        }
    }

}