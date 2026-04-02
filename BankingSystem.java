// Abstract class defining the template for an Account
abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateInterest();
}

// Subclass for Savings Account
class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.05; // 5% interest
    }
}

// Subclass for Loan Account
class LoanAccount extends Account {
    public LoanAccount(double balance) {
        super(balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.12; // 12% interest
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        // Using polymorphism: Account reference for different object types
        Account mySavings = new SavingsAccount(10000.0);
        Account myLoan = new LoanAccount(10000.0);

        // Displaying results
        printAccountInfo(mySavings);
        printAccountInfo(myLoan);
    }

    // Method demonstrating polymorphic behavior
    public static void printAccountInfo(Account acc) {
        String type = acc.getClass().getSimpleName();
        System.out.println(type + " interest: " + acc.calculateInterest());
    }
}
