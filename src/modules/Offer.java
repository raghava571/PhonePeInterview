package modules;

import exceptions.InsufficientBalanceException;
import models.Transaction;

public interface Offer {

    boolean isApplicable();
    double getCashBack(Transaction transaction);
}
