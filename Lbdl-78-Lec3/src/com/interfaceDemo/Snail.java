package com.interfaceDemo;

//we have 100 Animals(impl of interface class)
//now, we want to add a method to our interface
public class Snail implements Animal {
    @Override
    public void eat() {
        System.out.println("Eat for Snail");
    }



    //this doesn't speak
    @Override
    public void speak() {
         System.out.println("Snail sound");
        Animal.move();
    }

    public void hibernate(){

    }
}
