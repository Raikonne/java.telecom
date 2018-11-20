package com.excercise.java.telecom.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isIn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.excercise.java.telecom.data.DataProvider;

@RunWith(SpringRunner.class)
@WebMvcTest(PhoneNumberController.class)
public class PhoneNumberControllerTest {

    @Autowired
    private MockMvc mvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        DataProvider.getInstance().createNewCustomerWithPhoneNumber(1L, "testFornameOne", "testSurnameOne", 1L, "07471885134");
        DataProvider.getInstance().createNewCustomerWithPhoneNumber(2L, "testFornameTwo", "testSurnameTwo", 2L, "07471885135");
        DataProvider.getInstance().createNewCustomerWithPhoneNumber(3L, "testFornameTree", "testSurnameTree", 3L, "07471885136");
    }

    @Test
    public void getAllPhoneNumbersTest() throws Exception {
        final List<String> possbileNumberValues = new ArrayList<>();
        possbileNumberValues.add("07471885135");
        possbileNumberValues.add("07471885134");

        mvc.perform(get("/phonenumber/get/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(8)))
                .andExpect(jsonPath("$[0].number", isIn(possbileNumberValues)))
                .andExpect(jsonPath("$[0].hasBeenActivated", is(false)))
                .andExpect(jsonPath("$[1].number", isIn(possbileNumberValues)))
                .andExpect(jsonPath("$[1].hasBeenActivated", is(false)));
    }

    @Test
    public void activateNumberTest() throws Exception {

        mvc.perform(put("/phonenumber/update/07471885136")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("number", is("07471885136")))
                .andExpect(jsonPath("hasBeenActivated", is(true)));
    }

    @AfterClass
    public static void cleanup() {
        DataProvider.getInstance().setCustomers(new ArrayList<>());
        DataProvider.getInstance().setPhoneNumbers(new ArrayList<>());
    }
}
