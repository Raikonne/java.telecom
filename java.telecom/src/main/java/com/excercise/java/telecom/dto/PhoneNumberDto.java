package com.excercise.java.telecom.dto;

import com.excercise.java.telecom.model.PhoneNumber;

public class PhoneNumberDto {

    private final String number;

    private final boolean hasBeenActivated;

    private final long ownerId;

    private PhoneNumberDto(String number, boolean hasBeenActivated, long ownerId) {
        this.number = number;
        this.hasBeenActivated = hasBeenActivated;
        this.ownerId = ownerId;
    }

    public static PhoneNumberDto createNew(PhoneNumber phoneNumber) {
        return new PhoneNumberDto(phoneNumber.getNumber(), phoneNumber.hasBeenActivated(), phoneNumber.getId());
    }

    public String getNumber() {
        return number;
    }

    public boolean getHasBeenActivated() {
        return hasBeenActivated;
    }

    public long getOwnerId() {
        return ownerId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (hasBeenActivated ? 1231 : 1237);
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + (int) (ownerId ^ (ownerId >>> 32));
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
        final PhoneNumberDto other = (PhoneNumberDto) obj;
        if (hasBeenActivated != other.hasBeenActivated)
            return false;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        if (ownerId != other.ownerId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PhoneNumberDto [number=" + number + ", hasBeenActivated=" + hasBeenActivated + ", ownerId=" + ownerId + "]";
    }
}
