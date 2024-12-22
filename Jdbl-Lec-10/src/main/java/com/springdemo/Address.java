package com.springdemo;

public class Address {
    String pinCode;
    String city;

    public Address(String pinCode, String city) {
        System.out.println("Argumented Address constructor is called");
        this.pinCode = pinCode;
        this.city = city;
    }

    public Address() {
       System.out.println("default Address constructor is called");
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "pinCode='" + pinCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public void afterCreation(){
        System.out.println("address object is created");
    }
}
