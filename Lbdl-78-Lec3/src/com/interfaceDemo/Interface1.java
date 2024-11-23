package com.interfaceDemo;

public interface Interface1 {
     // int mode = 10;
      public static final int mode = 20;
    void subtract();

    //64 bit impl
    default int multiply(int a,int b){
        System.out.println("Multiply in Interface1");

        return a*b;
    }


}
