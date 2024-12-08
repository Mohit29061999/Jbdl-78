package com.genericExample;

import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {

    //it accepts a list of any type
    //it will match to any type
    public static void printList(List<?> list){
        //HW : check how to check type of list passed
//        if(list instanceof ArrayList<Integer>){
//
//        }
        System.out.println(list);
    }
}
