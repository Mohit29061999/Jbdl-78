package com.error;

public class InfiniteRec extends StackOverflowError {

//    public static void recursive(){
//        recursive();
//        //bad syntax
//        a=5;
//    }

    public  static void divide(int a,int b){

        //System.out.println(a/b);
        System.out.println(a*b);
    }

    public static void main(String[] args){
        //recursive();
        divide(2,0);
    }
}
