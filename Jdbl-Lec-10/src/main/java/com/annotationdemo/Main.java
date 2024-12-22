package com.annotationdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.annotationdemo");
        Address address = (Address) applicationContext.getBean("address");

        Address address2 = (Address) applicationContext.getBean("address");

        System.out.println(address.equals(address2));
    }
}
