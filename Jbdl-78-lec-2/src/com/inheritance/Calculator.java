package com.inheritance;

import com.inheritance.childPackage.NewParent;

//cyclic sort of dependency not allowed
public class Calculator  {
    //a=57
     int a =10;
     private int privateVar = 20;

    public Calculator(int a) {
//        this.a = a;
//        System.out.println(newParent);
        //System.out.println(this.hashCode());
    }

    public int add(int a, int b, int c){
        System.out.println("inside Calcualtor");
        return a+b+c;
    }

    public Calculator(){
       // System.out.println("Inside Calculator");
    }

    public void printA(){
        System.out.println(a);
    }

    private void printCurrentValue(int a){
        System.out.println(a);
    }
}

