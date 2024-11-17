package com.inheritance;

//whenever we are creating object of subclass parent constructor gets called first
public class AdvancedCalcuator extends MathsCalculator {
//    public int add(int a,int b,int c){
//        return a+b+c;
//    }
    int a =30;

    public AdvancedCalcuator(int a) {
//        super(a+1);
//        this.a = a;

        //every class extends Object class
        //Object class is superclass for all object
        //System.out.println(this.hashCode());
    }

    //if we have two same methods in parent and child
    //then child will get prefrence
    public int add(int a,int b,int c){
        System.out.println("inside advance Calcualtor");
        return a+b+c;
    }
    public AdvancedCalcuator(){

       // System.out.println("Inside Advance Calculator");
    }

    //use super keyword to go for parent one
    public void printA(){
      //call its parent and its parent is calling its parent
      super.printA();
    }
}
