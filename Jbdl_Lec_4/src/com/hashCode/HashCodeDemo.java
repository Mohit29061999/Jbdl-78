package com.hashCode;

//object is super class for all the classes
public class HashCodeDemo  {

    public static void main(String[] args){
        HashCodeDemo hashCodeDemo1 = new HashCodeDemo();

        //hashCodeDemo1.hashCode();

       // HashCodeDemo hashCodeDemo2 = new HashCodeDemo();
        HashCodeDemo hashCodeDemo2  = hashCodeDemo1;

        //same memory address
        System.out.println(hashCodeDemo1.equals(hashCodeDemo2));



        //hashCodeDemo.abcd();

    }
}
