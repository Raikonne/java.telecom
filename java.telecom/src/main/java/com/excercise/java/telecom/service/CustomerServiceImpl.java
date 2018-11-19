package com.excercise.java.telecom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excercise.java.telecom.dao.CustomerDao;
import com.excercise.java.telecom.dto.PhoneNumberDto;
import com.excercise.java.telecom.model.PhoneNumber;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<PhoneNumberDto> getAllPhoneNumbersForCustomer(long customerId) {
        final List<PhoneNumber> cutomerPhoneNumbers = customerDao.getAllPhoneNumbersForCustomer(customerId);
        final List<PhoneNumberDto> cutomerPhoneNumbersDto = new ArrayList<>();
        cutomerPhoneNumbers.forEach(number -> cutomerPhoneNumbersDto.add(PhoneNumberDto.createNew(number)));
        return cutomerPhoneNumbersDto;
    }
}
