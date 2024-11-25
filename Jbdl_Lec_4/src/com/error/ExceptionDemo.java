package com.error;

public class ExceptionDemo {

    static String[] arr = new String[10];

    public static void main(String[] args){
        //this will lead to an exception
        System.out.println(arr[11]);
    }
}
