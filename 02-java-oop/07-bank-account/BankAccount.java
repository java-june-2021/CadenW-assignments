import java.util.Random;
import java.util.ArrayList;

public class BankAccount{
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private double totalInAllAccounts;
    private static int numberOfAccounts;


    // Constructor for creating an account 

    public BankAccount(){
        this.accountNumber = randomNumbers();
        this.checkingBalance = 0.00;
        this.savingsBalance = 0.00;
        this.totalInAllAccounts = 0.00;
        numberOfAccounts ++;

    }
    // Getters 
    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }
    public double getTotal(){
        System.out.println("$" + totalInAllAccounts);
        return this.totalInAllAccounts;
    }
    public String getAccountNum(){
        System.out.println(accountNumber);
        return this.accountNumber;
    }
    
    public double getCheckingBalance(){
        System.out.println("$" + checkingBalance);
        return this.checkingBalance;
    }
    public double getSavingsBalance(){
        System.out.println("$" + savingsBalance);
        return this.savingsBalance;
    }

    // Setters 
    public void depositChecking(double amount){
        this.checkingBalance += amount;
        this.totalInAllAccounts += amount;
    }
    public void depositSavings(double amount){
        this.savingsBalance += amount;
        this.totalInAllAccounts += amount;
    }
    public void withdrawalChecking(double amount){
        if (this.checkingBalance - amount < 0.00){
            System.out.println("Insufficient Funds");
            return;
        }
        else{
            this.checkingBalance -= amount;
            this.totalInAllAccounts -= amount;
        }
    }
    public void withdrawalSavings(double amount){
        if (this.savingsBalance - amount < 0.00){
            System.out.println("Insufficient Funds");
            return;
        }
        else{
            this.savingsBalance -= amount;
            this.totalInAllAccounts -= amount;
        }
    }

    private static String randomNumbers(){
        Random r = new Random();
        String newNumber[];
        newNumber = new String[10];
        for (int i = 0; i < 10; i++){
            String number = String.valueOf(r.nextInt(9));
            newNumber[i] = number;
        }
        String newAccountNumber = newNumber[0] + newNumber[1]  + newNumber[2] + newNumber[3] + newNumber[4] +newNumber[5] + newNumber[6] + newNumber[7] + newNumber[8] + newNumber[9];
        return newAccountNumber;
    }

}