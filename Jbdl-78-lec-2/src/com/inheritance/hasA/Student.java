package com.inheritance.hasA;

public class Student {
    String name;
    Address address;


//    public void printAddress(){
//        System.out.println(address.getPincode());
//    }

    //aggregation
    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }



    public void printPincode(){

    }
}
