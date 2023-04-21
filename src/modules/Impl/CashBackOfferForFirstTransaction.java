package modules.Impl;

import exceptions.InsufficientBalanceException;
import models.Transaction;
import modules.Offer;
import modules.Wallet;

import java.util.Date;

public class CashBackOfferForFirstTransaction implements Offer {
    private double minAmount = 0.0;

    private Wallet wallet;

    public CashBackOfferForFirstTransaction(Wallet wallet) {
        this.wallet = wallet;
    }
    @Override
    public boolean isApplicable() {
        return wallet.getTransactions().size()==1;
    }

    @Override
    public double getCashBack(Transaction transaction)  {
        // Get 10% cashback on transaction
        if (isApplicable()) {
            return transaction.getAmount()*0.1;
        }
        return minAmount;
    }
}
