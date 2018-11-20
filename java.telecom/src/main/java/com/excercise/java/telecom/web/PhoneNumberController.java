package com.excercise.java.telecom.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.excercise.java.telecom.data.DataProvider;
import com.excercise.java.telecom.dto.PhoneNumberDto;
import com.excercise.java.telecom.model.PhoneNumber;

@Controller
@RequestMapping("phonenumber")
public class PhoneNumberController {

    /**
     * Retrieve a list of phone numbers
     *
     * @return list of all phone numbers
     */

    @GetMapping(path = "/get/all", produces = "application/json")
    public @ResponseBody List<PhoneNumberDto> getAllPhoneNumbers() {
        final List<PhoneNumberDto> cutomerPhoneNumbersDto = new ArrayList<>();

        DataProvider.getInstance()
                .getPhoneNumbers()
                .forEach(number -> cutomerPhoneNumbersDto.add(PhoneNumberDto.createNew(number)));

        return cutomerPhoneNumbersDto;
    }

    /**
     * Activate phone number
     *
     * @param number
     * @return activate phone number from the database with number value number
     */

    @PutMapping(path = "/update/{number}", produces = "application/json")
    public @ResponseBody PhoneNumberDto activateNumber(@PathVariable String number) {
        final Optional<PhoneNumber> optionalPhoneNumber = DataProvider.getInstance().activateAndGet(number);
        if (optionalPhoneNumber.isPresent()) {
            return PhoneNumberDto.createNew(optionalPhoneNumber.get());
        }
        return PhoneNumberDto.createWithoutOwner(number, Boolean.FALSE);
    }
}
