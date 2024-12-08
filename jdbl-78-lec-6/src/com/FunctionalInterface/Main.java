package com.FunctionalInterface;



public class Main {
    public static void main(String[] args){
        //to create a new class
        //create an object of that new class

//        FunctionalInterfaceDemo functionalInterface = new FunctionalInterfaceDemo() {
//            @Override
//            public void doSomething() {
//                System.out.println("It is an anymous class");
//            }
//        };

//        //lamba experssion
//        //we provide implmentation of doSomething() here
//        FunctionalInterfaceDemo functionalInterfaceDemoLamba = () -> {
//            System.out.println("It is an anymous class");
//        };
//
//        functionalInterfaceDemoLamba.doSomething();

        AddInterface addInterface = new AddInterface() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }

        };

        AddInterface addInterfaceLamba = (a,b) -> {
            return a+b;

        };

        System.out.println(addInterfaceLamba.add(3,5));

//        Comparable<Integer> comparable = (a) -> {
//            return 0;
//        };




    }
}
