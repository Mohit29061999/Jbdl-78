package com.springdemo;

public class Student {
    String name;
    Address address;

    public Student(String name, Address address) {
        System.out.println("Argumented constructor for Student is called");
        this.name = name;
        this.address = address;
    }

    //spring will create objects but it will use default constructor by default
    public Student() {
       System.out.println("Default constructor for Student is called");
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

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    //this is defined as init-method
    //so it will be called just after object creation
    public void afterCreation(){
        System.out.println("student object is created");
    }

    //destory method
    public void destory(){
        System.out.println("student object is about to get destoryed");
    }
}
