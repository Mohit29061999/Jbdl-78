package com.Singleton;

//class where we want to create one object only
public class SingletonDesignPattern {
    //eager initialisation
    static SingletonDesignPattern instance = new SingletonDesignPattern();
    //can't even create one object
    private SingletonDesignPattern(){

    }

    //revisit with multi-threading
    public static  SingletonDesignPattern getInstance(){

        //return instance;

        //lazy intialization
        if(instance == null ) {
            instance = new SingletonDesignPattern();
        }
        return instance;
    }
}
