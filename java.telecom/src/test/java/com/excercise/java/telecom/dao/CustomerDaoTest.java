package com.excercise.java.telecom.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.java.telecom.data.DataProvider;
import com.excercise.java.telecom.model.Customer;
import com.excercise.java.telecom.model.PhoneNumber;

public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    @Before
    public void setup() {
        customerDao = new CustomerDaoImpl();
        DataProvider.getInstance().createNewCustomerWithPhoneNumber(1L, "test1", "test1", 1L, "07471885134");
        DataProvider.getInstance().createNewCustomerWithPhoneNumber(2L, "test2", "test2", 2L, "07471885134");
    }

    @Test
    public void getByIdTest() {
        final Customer customer = new Customer(1L, "test1", "test1");
        final PhoneNumber phoneNumber = new PhoneNumber(1L, "07471885134");
        customer.addPhoneNumber(phoneNumber);
        phoneNumber.setOwner(customer);

        final Optional<Customer> optionalCustomer = customerDao.getById(1L);

        assertEquals(true, optionalCustomer.isPresent());
        assertEquals(customer, optionalCustomer.get());
    }

    @Test
    public void getByIdNonExistTest() {
        final Customer customer = new Customer(3L, "test3", "test3");
        final PhoneNumber phoneNumber = new PhoneNumber(3L, "07471885134");
        customer.addPhoneNumber(phoneNumber);
        phoneNumber.setOwner(customer);

        final Optional<Customer> optionalCustomer = customerDao.getById(3L);

        assertEquals(false, optionalCustomer.isPresent());
    }

    @Test
    public void getAllPhoneNumbersForCustomerTest() {
        final Customer customer = new Customer(1L, "test1", "test1");
        final PhoneNumber phoneNumber = new PhoneNumber(1L, "07471885134");
        customer.addPhoneNumber(phoneNumber);
        phoneNumber.setOwner(customer);

        final List<PhoneNumber> customerPhoneNumbers = customerDao.getAllPhoneNumbersForCustomer(1L);

        assertEquals(phoneNumber, customerPhoneNumbers.get(0));
    }
}
