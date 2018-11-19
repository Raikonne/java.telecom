package com.excercise.java.telecom;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.excercise.java.telecom.data.DataProvider;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void initSampleData() {
        DataProvider.getInstance().createNewCustomerWithPhoneNumber(1L, "testFornameOne", "testSurnameOne", 1L, "07471885134");
        DataProvider.getInstance().createNewCustomerWithPhoneNumber(2L, "testFornameTwo", "testSurnameTwo", 2L, "07471885134");
    }
}
