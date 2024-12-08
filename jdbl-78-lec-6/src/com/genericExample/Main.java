package com.genericExample;

import java.util.List;

public class Main {
    public static void main(String[] args){
//        PrintData printData = new PrintData(5);
//        printData.printData();
//
//        PrintDataFloat printDataFloat = new PrintDataFloat(5.1234);
//        printDataFloat.printData();

//        PrintDataGeneric<String> printDataGeneric = new PrintDataGeneric<>("abcd");
//        printDataGeneric.printData();

//        String temp = MethodGeneric.returnData("abcd");
//        System.out.println(temp);

        //List<Integer> integerList = List.of(1,2,3);
        List<Double> doubleList = List.of(1.0,2.0);
        WildCardDemo.printList(doubleList);

        List<Integer> integerList = List.of(1,2);
        WildCardDemo.printList(integerList);
    }
}
