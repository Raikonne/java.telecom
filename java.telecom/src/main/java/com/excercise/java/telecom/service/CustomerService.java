package com.excercise.java.telecom.service;

import java.util.List;

import com.excercise.java.telecom.dto.PhoneNumberDto;

public interface CustomerService {

    List<PhoneNumberDto> getAllPhoneNumbersForCustomer(long customerId);

}
