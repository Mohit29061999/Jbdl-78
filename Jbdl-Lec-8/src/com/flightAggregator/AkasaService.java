package com.flightAggregator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AkasaService implements FlightService{
    @Override
    public List<FlightData> getAllFlights(String src, String desc, Date date) {
        List<FlightData> flights = new ArrayList<>();
        flights.add(new FlightData(src,desc,date,Flights.AKASA_AIR));
        flights.add(new FlightData(src,desc,date,Flights.AKASA_AIR));
//        flights.add(new FlightData(src,desc,date,Flights.AKASA_AIR));

        //this should come to db
//        flights.add(new FlightData(src,"differntDesc",date,Flights.INDIGO));
//        flights.add(new FlightData("DifferentSrc",desc,date,Flights.INDIGO));

        return flights;
    }
}
