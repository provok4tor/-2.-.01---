package main.java.com.bank;
public class BankAccount {
    private static int nextAccountNumber = 1;
    private final int accountNumber;
    private double balance;
    private final Customer owner;

    public BankAccount(Customer owner, double initialBalance) {
        this.accountNumber = nextAccountNumber++;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) balance -= amount;
    }

    public int getAccountNumber() { 
        return accountNumber; 
    }
    
    public double getBalance() { 
        return balance; 
    }
    
    public Customer getOwner() { 
        return owner; 
    }
}
