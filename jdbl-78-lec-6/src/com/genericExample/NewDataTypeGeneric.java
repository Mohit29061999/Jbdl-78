package com.genericExample;

public class NewDataTypeGeneric <T extends NewDataType>{
    T  data;

    public NewDataTypeGeneric(T data) {
        this.data = data;
    }

    public void printData(){
        System.out.println(data);
    }
}
