package com.flightDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//@Primary   //this has high priority if we have mutiple bean of same type(FlightService)
//spring will use this one
public class AirIndiaService implements FlightService{
    @Override
    public List<String> flightNames() {
        List<String> flights = new ArrayList<>();
        flights.add("airIndia1");
        return flights;
    }
}
