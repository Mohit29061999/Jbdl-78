package com.flightDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//default bean name is class name camelcase
@Component("myFlight")

public class Flights {
    final String name = "airIndiaService";
    @Autowired
            @Qualifier(name)  //specifies which type to use
    FlightService flightService;

    public Flights() {
       System.out.println("constructor is called");
    }

    public FlightService getFlightService() {
        return flightService;
    }

    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }


    @PostConstruct //make db connection once object is created
    //log something once object is created
    public void postConstructMethod(){
        System.out.println("called after construction");
    }

  @PreDestroy
    public void preDestroy(){
        System.out.println("called before destruction");
    }
}
