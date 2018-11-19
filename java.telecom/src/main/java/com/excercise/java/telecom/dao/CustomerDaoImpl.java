package com.excercise.java.telecom.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.excercise.java.telecom.data.DataProvider;
import com.excercise.java.telecom.model.Customer;
import com.excercise.java.telecom.model.PhoneNumber;

@Repository("CustomerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<PhoneNumber> getAllPhoneNumbersForCustomer(long customerId) {
        final Optional<Customer> customer = getById(customerId);
        if (customer.isPresent()) {
            return customer.get()
                    .getPhoneNumbers();
        }
        System.out.println(String.format("Cannot find user with id : %d", customerId));
        return Collections.emptyList();
    }

    @Override
    public Optional<Customer> getById(long customerId) {
        return DataProvider.getInstance()
                .getCustomers()
                .stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst();
    }
}
