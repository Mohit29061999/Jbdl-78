package com.FunctionalInterface;

//Functional interface is a abstract class/interface where we have just one abstract method

//have this annotation though it is optional
//it will give error if we break FunctionalInterface condition
@java.lang.FunctionalInterface
public interface FunctionalInterfaceDemo {
    void doSomething();

//    default void nonAbstract(){
//
//    }

    //void secondAbstractMethod();

}
