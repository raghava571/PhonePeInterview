package Utils;

public class Util {

    public boolean isCashBackValid(double cashBack){
        return cashBack > 0;
    }

    public boolean isAmountNotValid(double amount){
        return amount <=0;
    }
}
