package com.excercise.java.telecom.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.excercise.java.telecom.model.Customer;
import com.excercise.java.telecom.model.PhoneNumber;

public class DataProviderTest {

    private DataProvider dataProvider;

    @Before
    public void setup() {
        dataProvider = DataProvider.getInstance();
    }

    @Test
    public void createNewCustomerWithPhoneNumber() {
        final Customer customer = new Customer(1L, "Test", "Test");
        final PhoneNumber phoneNumber = new PhoneNumber(1L, "12345678");

        customer.addPhoneNumber(phoneNumber);
        phoneNumber.setOwner(customer);

        dataProvider.createNewCustomerWithPhoneNumber(1L, "Test", "Test", 1L, "12345678");

        assertEquals(customer, dataProvider.getCustomers().get(0));
        assertEquals(phoneNumber, dataProvider.getPhoneNumbers().get(0));
    }
}