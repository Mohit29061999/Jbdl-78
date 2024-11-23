package com.outerClass;

//static -> access it by class
//non-static -> by object
public class Main {

    public static void main(String[] args){
        OuterClass outerClass = new OuterClass();
        System.out.println(outerClass.outerVarible);

        //give me outer class then i can create inner class
        //Parent class -> Child class and Child class can't exist on its own
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        System.out.println(innerClass.innerVariable);

        OuterClass.InnerStaticClass innerStaticClass = new OuterClass.InnerStaticClass();
        innerStaticClass.innerStaticVarible = 20;

        OuterClass.InnerStaticClass.innerStaticVariableStatic = 25;


    }
}
