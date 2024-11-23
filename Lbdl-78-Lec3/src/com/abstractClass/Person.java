package com.abstractClass;

//Ecomm application -> Buyer and Seller

//can't create object out of this class

//abstract class can have both abstract and non-abstract method
//but abstract method can only be in abstract class
public abstract class Person {
    String email;
    String name;

    public void getEmail(){
        System.out.println("email is something");
    }

    public void getName(){
        System.out.println("name is something");
    }

    //method without body
    abstract void doSomething();

    protected void doPrivate(){

    }

}
