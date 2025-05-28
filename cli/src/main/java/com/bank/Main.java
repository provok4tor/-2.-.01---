package com.bank;

/**
 * Главный класс приложения.
 */
public final class Main {

    /**
     * Приватный конструктор для предотвращения создания экземпляров утилитарного класса.
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

        BankAccount account = bank.openAccount(customer, 1000.0);
        ConsoleHelper.printMessage("Счет открыт: " + account.getAccountNumber());

        account.deposit(500.0);
        ConsoleHelper.printMessage("Баланс после пополнения: " + account.getBalance());

        account.withdraw(200.0);
        ConsoleHelper.printMessage("Баланс после снятия: " + account.getBalance());
    }
}
