package com.flightAggregator;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

//get one service and result all its flights
//what should be return type -> list of flights
public class CallableTask implements Callable<List<FlightData>> {
    String src;
    String desc;
    Date date;

    //interface
    FlightService flightService;



    public CallableTask(String src, String desc, Date date, FlightService flightService) {
        this.src = src;
        this.desc = desc;
        this.date = date;
        this.flightService = flightService;
    }



    @Override
    public List<FlightData> call() throws Exception {
       return flightService.getAllFlights(src,desc,date);
    }
}
