package main.java.com.bank;

/**
 * Главный класс приложения.
 */
public final class Main {

    /**
     * Приватный конструктор для предотвращения
     * создания экземпляров утилитарного класса.
     */
    private Main() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Инициализальный баланс для нового счета.
     */
    private static final double INITIAL_BALANCE = 1000.0;

    /**
     * Сумма пополнения счета.
     */
    private static final double DEPOSIT_AMOUNT = 500.0;

    /**
     * Сумма снятия со счета.
     */
    private static final double WITHDRAW_AMOUNT = 200.0;

    /**
     * Точка входа в приложение.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(final String[] args) {
        ConsoleHelper.printMessage("Добро пожаловать в систему банка!");

        Bank bank = new Bank("Мой Банк");

        Customer customer = new Customer("John Doe", "123456789");
        bank.addCustomer(customer);

        BankAccount account = bank.openAccount(customer, INITIAL_BALANCE);
        ConsoleHelper.printMessage("Счет открыт: "
                                   + account.getAccountNumber());

        account.deposit(DEPOSIT_AMOUNT);
        ConsoleHelper.printMessage("Баланс после пополнения: "
                                   + account.getBalance());

        account.withdraw(WITHDRAW_AMOUNT);
        ConsoleHelper.printMessage("Баланс после снятия: "
                                   + account.getBalance());
    }
}
