package com.excercise.java.telecom.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final long id;

    private final String firstName;

    private final String lastName;

    private final List<PhoneNumber> phoneNumbers;

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        phoneNumbers = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public boolean addPhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumbers.add(phoneNumber);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((phoneNumbers == null) ? 0 : phoneNumbers.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Customer other = (Customer) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id != other.id)
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (phoneNumbers == null) {
            if (other.phoneNumbers != null)
                return false;
        } else if (!phoneNumbers.equals(other.phoneNumbers))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumbers="
                + phoneNumbers + "]";
    }
}
