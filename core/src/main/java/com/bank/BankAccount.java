package main.java.com.bank;

/**
 * Класс, представляющий банковский счет.
 */
public final class BankAccount {
    /**
     * Статическое поле для генерации уникального номера счета.
     */
    private static int nextAccountNumber = 1;

    /**
     * Номер счета.
     */
    private final int accountNumber;

    /**
     * Баланс счета.
     */
    private double balance;

    /**
     * Владелец счета.
     */
    private final Customer owner;

    /**
     * Конструктор класса BankAccount.
     *
     * @param ownerParam       Владелец счета.
     * @param initialBalanceParam Начальный баланс счета.
     */
    public BankAccount(final Customer ownerParam,
                       final double initialBalanceParam) {
        this.accountNumber = nextAccountNumber++;
        this.owner = ownerParam;
        this.balance = initialBalanceParam;
    }

    /**
     * Пополнение счета на указанную сумму.
     *
     * @param amountParam Сумма для пополнения.
     */
    public void deposit(final double amountParam) {
        if (amountParam > 0) {
            balance += amountParam;
        }
    }

    /**
     * Списание со счета указанной суммы.
     *
     * @param amountParam Сумма для списания.
     */
    public void withdraw(final double amountParam) {
        if (amountParam > 0 && balance >= amountParam) {
            balance -= amountParam;
        }
    }

    /**
     * Возвращает номер счета.
     *
     * @return Номер счета.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Возвращает текущий баланс счета.
     *
     * @return Баланс счета.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Возвращает владельца счета.
     *
     * @return Владелец счета.
     */
    public Customer getOwner() {
        return owner;
    }
}
