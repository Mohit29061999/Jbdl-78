package com.inheritance.hasA;

public class Address {
    String city;
    String pincode;

    public Address(String city, String pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
