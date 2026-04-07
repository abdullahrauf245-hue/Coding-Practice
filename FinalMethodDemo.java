public class FinalMethodDemo {
    static class BankAccount {
        private double balance;

        BankAccount(double balance) {
            this.balance = balance;
        }

        final double getBalance() {
            return balance;
        }
    }

    static class SavingsAccount extends BankAccount {
        SavingsAccount(double balance) {
            super(balance);
        }
    }

    static class CheckingAccount extends BankAccount {
        CheckingAccount(double balance) {
            super(balance);
        }
    }   

    static class BusinessAccount extends BankAccount {
        BusinessAccount(double balance) {
            super(balance);
        }
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(5000.0);
        System.out.println("Balance: " + sa.getBalance());
        CheckingAccount ca = new CheckingAccount(10000.0);
        System.out.println("Balance: " + ca.getBalance());
        BusinessAccount ba = new BusinessAccount(20000.0);
        System.out.println("Balance: " + ba.getBalance());
    }
}
