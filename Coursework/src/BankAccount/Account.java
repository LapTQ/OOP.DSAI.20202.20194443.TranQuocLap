package BankAccount;

public class Account {
    private String owner;
    private String accNumber;
    private double balance;

    private boolean decrease(double amount) {
        if (this.balance - amount < 50000) {
            return false;
        }
        else {
            this.balance -= amount;
            return true;
        }
    }

    private void increase(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        boolean result = this.decrease(amount);
        if (result) {
            System.out.println("Successful");
        }
        else {
            System.out.println("Unsuccessful");
        }
        return result;
    }

    public void deposit(double amount) {
        this.increase(amount);
    }

    public Account(String owner, String accNumber) {
        this.owner = owner;
        this.accNumber = accNumber;
    }

    public Account(String owner, String accNumber, double initialBalance) {
        this(owner, accNumber);
        this.balance = initialBalance;
    }

    public double getBalance() {
        return this.balance;
    }
}



