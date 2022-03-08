import java.util.Scanner;

public class Account {

    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerID;

    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    void deposit(int amount) {
        if(amount != 0) {
            this.balance += amount;
            this.previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if(amount != 0) {
            this.balance -= amount;
            this.previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposit: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transactions occurred.");
        }
    }

    void calculateInterest(int years) {
        double interestRate = .0175;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("Current interest rate is: " + (100 * interestRate));
        System.out.println("After " + years + " your balance will be " + newBalance);
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance.");
        System.out.println("B. Make a deposit.");
        System.out.println("C. Make a withdrawn.");
        System.out.println("D. View previous transaction.");
        System.out.println("E. Calculate interest.");
        System.out.println("F. Exit.");

    }
}

