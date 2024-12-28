package com.annotationdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    //@Autowired
    private Address address;

    //don't even need to add @autowired tag
//    public Person(Address address) {
//        this.address = address;
//    }

    public Person(){
        System.out.println("Constructor is called");
    }

    public Address getAddress() {
        return address;
    }

    @Autowired
    public void setAddress(Address address) {
        System.out.println("Setter is called");
        this.address = address;
    }
}
