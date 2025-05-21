/**
 * Банковская система управления счетами
 * Функционал:
 * - Создание клиентов
 * - Открытие/закрытие счетов
 * - Операции пополнения/снятия
 * - Переводы между счетами
 */
public class Main {
    public static void main(String[] args) {
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