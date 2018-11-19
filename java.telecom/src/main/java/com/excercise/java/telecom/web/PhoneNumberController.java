package com.excercise.java.telecom.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.excercise.java.telecom.data.DataProvider;
import com.excercise.java.telecom.dto.PhoneNumberDto;

@Controller
@RequestMapping("phonenumber")
public class PhoneNumberController {

    /**
     * Retrieve a list of phone numbers
     *
     * @return list of all phone numbers
     */

    @GetMapping(path = "/get/all", produces = "application/json")
    public @ResponseBody List<PhoneNumberDto> getAll() {
        final List<PhoneNumberDto> cutomerPhoneNumbersDto = new ArrayList<>();

        DataProvider.getInstance()
                .getPhoneNumbers()
                .forEach(number -> cutomerPhoneNumbersDto.add(PhoneNumberDto.createNew(number)));

        return cutomerPhoneNumbersDto;
    }

    /**
     * Activate phone number
     *
     * @param customerId
     * @return list of phone numbers for customer for with id of customerId
     */

    @PutMapping(path = "/update/{number}", produces = "application/json")
    public @ResponseBody boolean activateNumber(@PathVariable String number) {
        return DataProvider.getInstance().activateNumber(number);
    }

}
