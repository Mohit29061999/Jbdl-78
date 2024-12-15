package com.flightAggregator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirIndiaService implements FlightService{
    @Override
    public List<FlightData> getAllFlights(String src, String desc, Date date) {
        List<FlightData> flights = new ArrayList<>();
        flights.add(new FlightData(src,desc,date,Flights.AIR_INDIA));
        flights.add(new FlightData(src,desc,date,Flights.AIR_INDIA));
        flights.add(new FlightData(src,desc,date,Flights.AIR_INDIA));
        flights.add(new FlightData(src,desc,date,Flights.AIR_INDIA));
        return flights;
    }
}
