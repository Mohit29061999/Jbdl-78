package com.inheritance.polymorphism;



public class Calculator  {

    public int  add(int a,int b){
        System.out.println("Inside caluclator");
        return a+b;
    }

    //cannot acheive compile time polymorphism by changing return type
//    public void  add(int a,int b){
//        System.out.println("Inside caluclator");
//
//    }

    //changing access modifier will not work for compile time polymorphism
//    protected int  add(int a,int b){
//        System.out.println("Inside caluclator");
//        return a+b;
//    }

    //static keyword will also not work for compile time polymorphism
//    public static int  add(int a,int b){
//        System.out.println("Inside caluclator");
//        return a+b;
//    }





//    public void  add(int a,int b){
//
//    }

//    //either vary the type of argument passed
//    public void  add(String a,int b){
//       // return a+b;
//    }

//    //number of argument passed
//    public int  add(int a,int b,int c){
//        return a+b+c;
//    }

}
