package com.annotationdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//bean name will be camel case for your class name
//NotificationService -> notificationService
public class Address {
    String city;
    String pincode;

//    public Address(String city, String pincode) {
//        this.city = city;
//        this.pincode = pincode;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
