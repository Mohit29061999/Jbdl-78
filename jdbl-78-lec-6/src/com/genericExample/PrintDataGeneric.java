package com.genericExample;

import java.util.HashMap;

public class PrintDataGeneric <T>{
    T data;

    public PrintDataGeneric(T data) {
        this.data = data;
    }



    public void printData(){
        System.out.println(data);
    }
}
