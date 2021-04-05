package BankAccount;

public class SavingAccount extends Account {
    private double annualInterestRate;

    public double monthlyInterest() {
        return this.annualInterestRate * this.getBalance() / 12.0;
    }

    public SavingAccount(String owner, String accNumber, double annualInterestRate) {
        super(owner, accNumber);
        this.annualInterestRate = annualInterestRate;
    }

    public SavingAccount(String owner, String accNumber, double initialBalance, double annualInterestRate) {
        super(owner, accNumber, initialBalance);
        this.annualInterestRate = annualInterestRate;
    }

    public boolean withdraw(double amount) {
        System.out.println("Unsuccessful");
        return false;
    }
}