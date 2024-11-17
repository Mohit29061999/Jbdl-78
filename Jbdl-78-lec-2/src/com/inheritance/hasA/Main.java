package com.inheritance.hasA;

import com.inheritance.AdvancedCalcuator;

public class Main {

    public static void main(String[] args){
      Address address = new Address("Delhi","110056");
       Student student = new Student("mohit",address);
       student.printPincode();


    }
}
