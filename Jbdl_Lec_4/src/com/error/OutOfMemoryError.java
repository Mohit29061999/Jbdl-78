package com.error;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryError {
    static List<String> values = new ArrayList<>();

    public static void main(String[] args){
        //infinite loop
        while(true){
            //primitive
            String value = "abcd";
            values.add(value);

        }
    }
}
