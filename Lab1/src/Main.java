/**
 * Банковская система управления счетами
 * Функционал:
 * - Создание клиентов
 * - Открытие/закрытие счетов
 * - Операции пополнения/снятия
 * - Переводы между счетами
 */
public class Main {
    private static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        System.out.println("Bank System v" + VERSION);
        Bank bank = new Bank("Альфа-Банк");

        Customer ivan = new Customer("Иван Петров", "1234");
        bank.addCustomer(ivan);
        BankAccount ivanAccount = bank.openAccount(ivan, 1000);

        ivanAccount.deposit(500);
        ivanAccount.withdraw(200);

        Customer petr = new Customer("Пётр Иванов", "4321");
        bank.addCustomer(petr);
        BankAccount petrAccount = bank.openAccount(petr, 1000);

        petrAccount.deposit(800);
        petrAccount.withdraw(333);

        bank.printAllCustomers();
    }
}