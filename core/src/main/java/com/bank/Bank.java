package com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Класс, представляющий банк.
 */
public final class Bank {
    /**
     * Логгер для класса Bank.
     */
    private static final Logger logger = Logger.getLogger(Bank.class.getName());

    /**
     * Название банка.
     */
    private final String name;

    /**
     * Список клиентов банка.
     */
    private final List<Customer> customers = new ArrayList<>();

    /**
     * Список банковских счетов.
     */
    private final List<BankAccount> accounts = new ArrayList<>();

    /**
     * Конструктор класса Bank.
     *
     * @param name Название банка.
     */
    public Bank(final String name) {
        this.name = name;
        logger.log(Level.INFO, "Bank created: {0}", name);
    }

    /**
     * Добавляет клиента в банк.
     *
     * @param customer Клиент для добавления.
     */
    public void addCustomer(final Customer customer) {
        customers.add(customer);
        logger.log(Level.INFO, "Customer added: {0}", customer.getName());
    }

    /**
     * Открывает новый банковский счёт для клиента.
     *
     * @param customer       Клиент, для которого открывается счёт.
     * @param initialBalance Начальный баланс счёта.
     * @return Созданный банковский счёт.
     */
    public BankAccount openAccount(final Customer customer, final double initialBalance) {
        final BankAccount account = new BankAccount(customer, initialBalance);
        accounts.add(account);
        logger.log(Level.INFO, "Account opened: {0} for {1}",
                new Object[]{account.getAccountNumber(), customer.getName()});
        return account;
    }

    /**
     * Находит клиента по идентификатору паспорта.
     *
     * @param passportId Идентификатор паспорта клиента.
     * @return Клиент, если найден, иначе null.
     */
    public Customer findCustomer(final String passportId) {
        return customers.stream()
                .filter(c -> c.getPassportId().equals(passportId))
                .findFirst()
                .orElse(null);
    }

    /**
     * Возвращает список банковских счетов клиента.
     *
     * @param customer Клиент, чьи счета нужно найти.
     * @return Список банковских счетов клиента.
     */
    public List<BankAccount> getCustomerAccounts(final Customer customer) {
        return accounts.stream()
                .filter(a -> a.getOwner().equals(customer))
                .collect(Collectors.toList());
    }
}
