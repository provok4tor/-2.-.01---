package main.java.com.bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("AlphaBank");

        Customer customer1 = new Customer("John Doe", "AB123456");
        bank.addCustomer(customer1);
        BankAccount account1 = bank.openAccount(customer1, 1000);

        account1.deposit(500);
        account1.withdraw(200);

        System.out.println("Balance: " + account1.getBalance());
    }
}