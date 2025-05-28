package main.java.com.bank;

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
    private static final Logger LOGGER = Logger.getLogger(Bank.class.getName());

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
     * @param nameParam Название банка.
     */
    public Bank(final String nameParam) {
        this.name = nameParam;
        LOGGER.log(Level.INFO, "Bank created: {0}", nameParam);
    }

    /**
     * Добавляет клиента в банк.
     *
     * @param customerParam Клиент для добавления.
     */
    public void addCustomer(final Customer customerParam) {
        customers.add(customerParam);
        LOGGER.log(Level.INFO, "Customer added: {0}", customerParam.getName());
    }

    /**
     * Открывает новый банковский счёт для клиента.
     *
     * @param customerParam       Клиент, для которого открывается счёт.
     * @param initialBalanceParam Начальный баланс счёта.
     * @return Созданный банковский счёт.
     */
    public BankAccount openAccount(final Customer customerParam, final double initialBalanceParam) {
        final BankAccount account = new BankAccount(customerParam, initialBalanceParam);
        accounts.add(account);
        LOGGER.log(
            Level.INFO,
            "Account opened: {0} for {1}",
            new Object[]{account.getAccountNumber(), customerParam.getName()}
        );
        return account;
    }

    /**
     * Находит клиента по идентификатору паспорта.
     *
     * @param passportIdParam Идентификатор паспорта клиента.
     * @return Клиент, если найден, иначе null.
     */
    public Customer findCustomer(final String passportIdParam) {
        return customers.stream()
                .filter(c -> c.getPassportId().equals(passportIdParam))
                .findFirst()
                .orElse(null);
    }

    /**
     * Возвращает список банковских счетов клиента.
     *
     * @param customerParam Клиент, чьи счета нужно найти.
     * @return Список банковских счетов клиента.
     */
    public List<BankAccount> getCustomerAccounts(final Customer customerParam) {
        return accounts.stream()
                .filter(a -> a.getOwner().equals(customerParam))
                .collect(Collectors.toList());
    }
}
