import java.util.Random;
import java.util.ArrayList;

public class BankAccountTest{
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();
        BankAccount account4 = new BankAccount();
        account1.getAccountNum();
        account1.getCheckingBalance();
        account1.getSavingsBalance();
        account1.depositChecking(100.00);
        account1.getCheckingBalance();
        account1.depositSavings(100.00);
        account1.getSavingsBalance();
        account2.depositSavings(500.06);
        account2.getSavingsBalance();
        account1.getTotal();
        account2.depositSavings(500.06);
        account1.withdrawalChecking(500.00);
        account1.withdrawalSavings(40.00);
        account1.getTotal();
        account1.getCheckingBalance();
        account1.getSavingsBalance();
        account1.withdrawalSavings(500.00);





    }
}