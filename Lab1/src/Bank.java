import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final List<Customer> customers = new ArrayList<>();
    private final List<BankAccount> accounts = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public BankAccount openAccount(Customer customer, double initialBalance) {
        BankAccount account = new BankAccount(customer, initialBalance);
        accounts.add(account);
        return account;
    }

    // Дополнительные методы можно добавить позже
}