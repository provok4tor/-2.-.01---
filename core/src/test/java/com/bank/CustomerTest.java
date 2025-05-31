package com.bank;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
