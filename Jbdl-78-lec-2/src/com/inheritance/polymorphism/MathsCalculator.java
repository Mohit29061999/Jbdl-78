package com.inheritance.polymorphism;

public class MathsCalculator extends  Calculator {

    public int multiply(int a,int b){
        return a*b;
    }

    public int  add(int a,int b){

        System.out.println("Inside maths");
        return a+b;
    }
}
