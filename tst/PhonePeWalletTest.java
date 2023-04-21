

import exceptions.InsufficientBalanceException;
import models.SortCondition;
import models.Transaction;
import models.TransactionType;
import modules.Impl.AmountTransactionSorter;
import modules.Impl.PhonePeWallet;
import modules.Impl.SenderTransactionFilter;


import java.util.ArrayList;
import java.util.List;

public class PhonePeWalletTest {
    private PhonePeWallet wallet;
//    @Test
    public void testFetchBalance() {
        double balance = wallet.fetchBalance();
//        AssertThat.assertEquals(5000.0, balance);
    }

//    @Test
    public void testSendMoney() throws InsufficientBalanceException {
        wallet.registerUser("Tej", "9939939423");
        wallet.topUpWallet(2000.00,  "UPI", TransactionType.ADDED);
        Transaction transaction =  wallet.getTransactions().get(0);
//        AssetThat.assertEquals(transaction.getAmount(), 2000.00);
    }

    @Test
    public void testGetTransactions() throws InsufficientBalanceException {
        wallet.registerUser("Tej", "9939939423");
        wallet.topUpWallet(2000.00,  "UPI", TransactionType.ADDED);
        wallet.sendMoney("Pawan Kalyan",  100.00);
//        AssertThat.assertEquals(2, wallet.getTransactions().size());
    }

    @Test(Exception = InsufficientBalanceException.class)
    public void testGetTransactions() throws InsufficientBalanceException {
        wallet.registerUser("Tej", "9939939423");
        wallet.topUpWallet(-220,  "UPI", TransactionType.ADDED);
    }
}
