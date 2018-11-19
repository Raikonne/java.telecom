package com.excercise.java.telecom.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.excercise.java.telecom.dto.PhoneNumberDto;
import com.excercise.java.telecom.model.Customer;
import com.excercise.java.telecom.model.PhoneNumber;
import com.excercise.java.telecom.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllPhoneNumberForCustomerTest() throws Exception {
        final Customer customer = new Customer(1L, "test1", "test1");
        final PhoneNumber phoneNumber = new PhoneNumber(1L, "07471885134");
        customer.addPhoneNumber(phoneNumber);
        phoneNumber.setOwner(customer);

        final List<PhoneNumberDto> customerPhoneNumbersDto = new ArrayList<>();
        customerPhoneNumbersDto.add(PhoneNumberDto.createNew(phoneNumber));

        when(customerService.getAllPhoneNumbersForCustomer(1L)).thenReturn(customerPhoneNumbersDto);

        mvc.perform(get("/customer/get/1/phonenumbers/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].number", is(phoneNumber.getNumber())));

        verify(customerService, times(1)).getAllPhoneNumbersForCustomer(1L);
        verifyNoMoreInteractions(customerService);
    }
}
