package com.flightAggregator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//give me all flights running of type Indigo from
//this source to desc at at this date
public class IndigoService implements FlightService{
    @Override
    public List<FlightData> getAllFlights(String src, String desc, Date date) {
        //result should come from db
        List<FlightData> flights = new ArrayList<>();
        flights.add(new FlightData(src,desc,date,Flights.INDIGO));
        flights.add(new FlightData(src,desc,date,Flights.INDIGO));
        flights.add(new FlightData(src,desc,date,Flights.INDIGO));

        //this should come to db
//        flights.add(new FlightData(src,"differntDesc",date,Flights.INDIGO));
//        flights.add(new FlightData("DifferentSrc",desc,date,Flights.INDIGO));

        return flights;
    }
}
