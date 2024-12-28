package com.flightDemo;

import com.annotationdemo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.flightDemo");

        Flights flights = (Flights) applicationContext.getBean("myFlight");
        System.out.println(flights.getFlightService().flightNames());

        ((AnnotationConfigApplicationContext)applicationContext).close();
    }
}
