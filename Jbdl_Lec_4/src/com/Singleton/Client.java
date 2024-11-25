package com.Singleton;

public class Client {
    public static void main(String[] args){
//        SingletonDesignPattern SingletonDesignPattern1 = new SingletonDesignPattern();
//        SingletonDesignPattern SingletonDesignPattern2 = new SingletonDesignPattern();


        SingletonDesignPattern singletonDesignPattern1 = SingletonDesignPattern.getInstance();
        SingletonDesignPattern singletonDesignPattern2 = SingletonDesignPattern.getInstance();


        System.out.println(singletonDesignPattern1.equals(singletonDesignPattern2));
    }
}
