package com.outerClass;


//1 code readability

//Class response
//class data

//builder pattern
//check it out
public class OuterClass {
     int outerVarible  = 10 ;

    //define an inner class
    public class InnerClass {
        int innerVariable = 20;
    }

    //static means property of class
    public static class InnerStaticClass {
        int innerStaticVarible = 20;
        static int innerStaticVariableStatic = 25;
    }
}
