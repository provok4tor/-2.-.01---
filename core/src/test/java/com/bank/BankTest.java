package main.java.com.bank;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import main.java.com.bank.Bank;
import main.java.com.bank.BankAccount;
import main.java.com.bank.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class BankTest {
    private Bank bank;
    private Customer customer;
    private Customer customer2;
    private BankAccount account;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        bank = new Bank("TestBank");
        customer = mock(Customer.class);
        customer2 = mock(Customer.class);
        account = mock(BankAccount.class);
        account2 = mock(BankAccount.class);

        // Настройка моков
        when(customer.getName()).thenReturn("John Doe");
        when(customer.getPassportId()).thenReturn("PASS123");
        when(customer2.getName()).thenReturn("Jane Smith");
        when(customer2.getPassportId()).thenReturn("PASS456");

        when(account.getOwner()).thenReturn(customer);
        when(account.getAccountNumber()).thenReturn(1);
        when(account.getBalance()).thenReturn(1000.0);

        when(account2.getOwner()).thenReturn(customer2);
        when(account2.getAccountNumber()).thenReturn(2);
        when(account2.getBalance()).thenReturn(500.0);
    }

    // Тесты для операций с клиентами
    @Test
    void testAddCustomer() {
        bank.addCustomer(customer);
        assertNotNull(bank.findCustomer("PASS123"));
        assertEquals(1, bank.getCustomerAccounts(customer).size());
    }


    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(customer, 500);
        account.withdraw(200);
        assertEquals(300, account.getBalance());
    }

    @Test
    void testAddDuplicateCustomer() {
        bank.addCustomer(customer);
        bank.addCustomer(customer); // Попытка добавить того же клиента
        assertEquals(1, bank.getCustomerAccounts(customer).size());
    }

    // Тесты для операций со счетами
    @Test
    void testOpenAccount() {
        bank.addCustomer(customer);
        BankAccount newAccount = bank.openAccount(customer, 1000);
        assertNotNull(newAccount);
        assertEquals(1, bank.getCustomerAccounts(customer).size());
    }

    @Test
    void testOpenMultipleAccounts() {
        bank.addCustomer(customer);
        bank.openAccount(customer, 1000);
        bank.openAccount(customer, 2000);
        assertEquals(2, bank.getCustomerAccounts(customer).size());
    }

    @Test
    void testOpenAccountForNonExistentCustomer() {
        BankAccount newAccount = bank.openAccount(customer, 1000);
        assertNull(newAccount);
    }

    // Тесты для поиска
    @Test
    void testFindCustomer() {
        bank.addCustomer(customer);
        Customer found = bank.findCustomer("PASS123");
        assertNotNull(found);
        assertEquals("John Doe", found.getName());
    }

    @Test
    void testFindCustomerNotFound() {
        assertNull(bank.findCustomer("UNKNOWN_ID"));
    }

    @Test
    void testGetCustomerAccounts() {
        bank.addCustomer(customer);
        bank.openAccount(customer, 1000);
        bank.openAccount(customer, 2000);

        List<BankAccount> accounts = bank.getCustomerAccounts(customer);
        assertEquals(2, accounts.size());
    }

    // Тесты для транзакций
    @Test
    void testDeposit() {
        bank.addCustomer(customer);
        BankAccount acc = bank.openAccount(customer, 1000);
        acc.deposit(500);
        assertEquals(1500, acc.getBalance());
    }

    @Test
    void testWithdrawSufficientFunds() {
        bank.addCustomer(customer);
        BankAccount acc = bank.openAccount(customer, 1000);
        acc.withdraw(500);
        assertEquals(500, acc.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        bank.addCustomer(customer);
        BankAccount acc = bank.openAccount(customer, 1000);
        acc.withdraw(1500); // Попытка снять больше, чем есть
        assertEquals(1000, acc.getBalance()); // Баланс не должен измениться
    }
}
