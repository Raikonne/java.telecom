package com.excercise.java.telecom.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.excercise.java.telecom.dto.PhoneNumberDto;
import com.excercise.java.telecom.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Retrieve a list of phone numbers for a customer
     *
     * @param customerId
     * @return list of phone numbers for customer for with id of customerId
     */

    @GetMapping(path = "/get/{customerId}/phonenumbers/all", produces = "application/json")
    public @ResponseBody List<PhoneNumberDto> getAllPhoneNumberForCustomer(@PathVariable String customerId) {
        return customerService.getAllPhoneNumbersForCustomer(Long.valueOf(customerId));
    }
}
