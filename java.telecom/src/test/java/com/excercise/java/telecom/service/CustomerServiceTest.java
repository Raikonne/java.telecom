package com.excercise.java.telecom.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.excercise.java.telecom.dao.CustomerDao;
import com.excercise.java.telecom.dto.PhoneNumberDto;
import com.excercise.java.telecom.model.Customer;
import com.excercise.java.telecom.model.PhoneNumber;

public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerDao customerDaoMock;

    @Before
    public void setup() {
        customerService = new CustomerServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllPhoneNumbersForCustomerTest() {
        final Customer customer = new Customer(1L, "test1", "test1");
        final PhoneNumber phoneNumber = new PhoneNumber(1L, "07471885134");
        customer.addPhoneNumber(phoneNumber);
        phoneNumber.setOwner(customer);

        final List<PhoneNumber> customerPhones = new ArrayList<>();
        customerPhones.add(phoneNumber);

        when(customerDaoMock.getAllPhoneNumbersForCustomer(1L)).thenReturn(customerPhones);

        final List<PhoneNumberDto> customerPhonesDto = customerService.getAllPhoneNumbersForCustomer(1L);

        assertEquals(PhoneNumberDto.createNew(phoneNumber), customerPhonesDto.get(0));

        verify(customerDaoMock, times(1)).getAllPhoneNumbersForCustomer(1L);
        verifyNoMoreInteractions(customerDaoMock);
    }
}
