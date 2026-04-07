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

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(5000.0);
        System.out.println("Balance: " + sa.getBalance());
    }
}
