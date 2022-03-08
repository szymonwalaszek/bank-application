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

    private void deposit(int amount) {
        if(amount != 0) {
            this.balance += amount;
            this.previousTransaction = amount;
        }
    }

    private void withdraw(int amount) {
        if(amount != 0) {
            this.balance -= amount;
            this.previousTransaction = -amount;
        }
    }

    private void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposit: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transactions occurred.");
        }
    }

    private void calculateInterest(int years) {
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
        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char customerChoice = scanner.next().charAt(0);
            option = Character.toUpperCase(customerChoice);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("==========================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("==========================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("==========================");
                    getPreviousTransaction();
                    System.out.println("==========================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("==========================");
                    break;
                default:
                    System.out.println("Error. Invalid option. Please enter A, B, C, D, E or F.");
                    break;
            }

        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}

