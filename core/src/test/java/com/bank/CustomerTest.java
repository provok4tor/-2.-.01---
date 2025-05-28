package test.java.com.bank;

import main.java.com.bank.Bank;
import main.java.com.bank.BankAccount;
import main.java.com.bank.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.mockito.Mockito.*;

import java.util.List;

public class CustomerTest {

    @Test
    public void testGetName() {
        Customer customer = new Customer("John Doe", "123456789");
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testGetPassportId() {
        Customer customer = new Customer("John Doe", "123456789");
        assertEquals("123456789", customer.getPassportId());
    }
}
