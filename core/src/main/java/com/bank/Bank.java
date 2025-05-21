package main.java.com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Bank {
    private static final Logger logger = Logger.getLogger(Bank.class.getName());
    private final String name;
    private final List<Customer> customers = new ArrayList<>();
    private final List<BankAccount> accounts = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
        logger.log(Level.INFO, "Bank created: {0}", name);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        logger.log(Level.INFO, "Customer added: {0}", customer.getName());
    }

    public BankAccount openAccount(Customer customer, double initialBalance) {
        BankAccount account = new BankAccount(customer, initialBalance);
        accounts.add(account);
        logger.log(Level.INFO, "Account opened: {0} for {1}",
                new Object[]{account.getAccountNumber(), customer.getName()});
        return account;
    }

    public Customer findCustomer(String passportId) {
        return customers.stream()
                .filter(c -> c.getPassportId().equals(passportId))
                .findFirst()
                .orElse(null);
    }

    public List<BankAccount> getCustomerAccounts(Customer customer) {
        return accounts.stream()
                .filter(a -> a.getOwner().equals(customer))
                .collect(Collectors.toList());
    }
}