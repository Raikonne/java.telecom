package com.excercise.java.telecom.model;

public class PhoneNumber {

    private final Long id;

    private final String number;

    private boolean hasBeenActivated;

    private Customer owner;

    public PhoneNumber(Long id, String number) {
        this.id = id;
        this.number = number;
        this.hasBeenActivated = false;
    }

    public boolean hasBeenActivated() {
        return hasBeenActivated;
    }

    public void setHasBeenActivated(boolean hasBeenActivated) {
        this.hasBeenActivated = hasBeenActivated;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (hasBeenActivated ? 1231 : 1237);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
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
        final PhoneNumber other = (PhoneNumber) obj;
        if (hasBeenActivated != other.hasBeenActivated)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PhoneNumber [id=" + id + ", number=" + number + ", hasBeenActivated=" + hasBeenActivated + "]";
    }

}