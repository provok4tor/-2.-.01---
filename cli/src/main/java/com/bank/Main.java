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
     * Точка входа в приложение.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(final String[] args) {
        ConsoleHelper.printMessage("Добро пожаловать в систему банка!");

        Bank bank = new Bank("Мой Банк");

        Customer customer = new Customer("John Doe", "123456789");
        bank.addCustomer(customer);

        double initialBalance = 1000.0;
        BankAccount account = bank.openAccount(customer, initialBalance);
        ConsoleHelper.printMessage("Счет открыт: "
                                   + account.getAccountNumber());

        double depositAmount = 500.0;
        account.deposit(depositAmount);
        ConsoleHelper.printMessage("Баланс после пополнения: "
                                   + account.getBalance());

        double withdrawAmount = 200.0;
        account.withdraw(withdrawAmount);
        ConsoleHelper.printMessage("Баланс после снятия: "
                                   + account.getBalance());
    }
}
