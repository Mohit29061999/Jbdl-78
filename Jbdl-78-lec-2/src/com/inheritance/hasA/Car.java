package com.inheritance.hasA;

public class Car {
    String name;
    Wheel wheel;

    //composition
    public Car(String name) {
        this.name = name;
        this.wheel =  new Wheel();
    }
}
