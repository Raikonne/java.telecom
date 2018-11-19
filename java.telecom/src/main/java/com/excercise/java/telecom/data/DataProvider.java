package com.excercise.java.telecom.data;

import java.util.ArrayList;
import java.util.List;

import com.excercise.java.telecom.model.Customer;
import com.excercise.java.telecom.model.PhoneNumber;

public class DataProvider {

    private final List<Customer> customers = new ArrayList<>();

    private final List<PhoneNumber> phoneNumbers = new ArrayList<>();

    private static final DataProvider instance = new DataProvider();

    private DataProvider() {
    }

    public static DataProvider getInstance() {
        return instance;
    }

    public void createNewCustomerWithPhoneNumber(long customerId, String firstName, String lastName, long phoneNumberId, String number) {
        final Customer customer = new Customer(customerId, firstName, lastName);
        final PhoneNumber phoneNumber = new PhoneNumber(phoneNumberId, number);
        customer.addPhoneNumber(phoneNumber);
        phoneNumber.setOwner(customer);
        System.out.println(String.format("Customer created: %s", customer.toString()));
        phoneNumbers.add(phoneNumber);
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customers == null) ? 0 : customers.hashCode());
        result = prime * result + ((phoneNumbers == null) ? 0 : phoneNumbers.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DataProvider other = (DataProvider) obj;
        if (customers == null) {
            if (other.customers != null)
                return false;
        } else if (!customers.equals(other.customers))
            return false;
        if (phoneNumbers == null) {
            if (other.phoneNumbers != null)
                return false;
        } else if (!phoneNumbers.equals(other.phoneNumbers))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DataProvider [customers=" + customers + ", phoneNumbers=" + phoneNumbers + "]";
    }
}
