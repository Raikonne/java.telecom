package com.excercise.java.telecom.dao;

import java.util.List;
import java.util.Optional;

import com.excercise.java.telecom.model.Customer;
import com.excercise.java.telecom.model.PhoneNumber;

public interface CustomerDao {

    public List<PhoneNumber> getAllPhoneNumbersForCustomer(long customerId);

    public Optional<Customer> getById(long id);
}
