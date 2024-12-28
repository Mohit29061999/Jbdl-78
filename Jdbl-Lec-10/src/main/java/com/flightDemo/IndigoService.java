package com.flightDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class IndigoService implements FlightService{
    @Override
    public List<String> flightNames() {
        List<String> flights = new ArrayList<>();
        flights.add("indigo1");
        return flights;
    }
}
