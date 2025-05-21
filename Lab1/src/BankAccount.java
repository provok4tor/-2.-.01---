public class BankAccount {
    private static int nextId = 1;
    private final int id;
    private double balance;
    private final Customer owner;

    public BankAccount(Customer owner, double initialBalance) {
        this.id = nextId++;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) balance -= amount;
    }

    // Геттеры
    public int getId() { return id; }
    public double getBalance() { return balance; }
    public Customer getOwner() { return owner; }
}