package com.interfaceDemo;

public interface Interface2 {
    void add();

    //128 bit impl
    default int multiply(int a,int b,int c){
        System.out.println("Multiply in Interface2");
        return a*b*c;
    }

//    default int multiply(int a,int b,int c){
//
//    }
}
