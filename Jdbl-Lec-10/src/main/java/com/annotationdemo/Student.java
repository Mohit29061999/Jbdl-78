package com.annotationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;


public class Student {

    String name;

    class Temp{
        String temp;

    }


    public static void main(String[] agrs){
        //create object of Solution class
        //through that create object of our class
        Student student = new Student("mohit",null);
        Student.Temp temp = student.new Temp();
        temp.temp = "abcd";


    }


    //use it from bean
    //ref in xml
    //field injection
    //not recommneded
    //it will be used mostly by dev
    @Autowired
    private Address address;

    //constructor injection
    @Autowired
    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

//    //setter injection
//    @Autowired
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
