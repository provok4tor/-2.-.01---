package com.bank;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class BankAccountTest {
    private BankAccount account;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", "123456789");
        account = new BankAccount(customer, 1000.0);
    }

    @Test
    public void testDeposit0() {
        account.deposit(0);
        assertNotNull(account.getBalance());
    }
    @Test
    public void testDeposit1() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    public void testDeposit2() {
        account.deposit(200.0);
        assertNotEquals(1800.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(200.0);
        assertEquals(800.0, account.getBalance());
    }

    @Test
    public void testGetAccountNumber() {
        assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    public void testGetOwner() {
        assertEquals(customer, account.getOwner());
    }
}
