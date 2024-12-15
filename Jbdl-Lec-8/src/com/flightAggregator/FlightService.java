package com.flightAggregator;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<FlightData> getAllFlights(String src, String desc, Date date);
}
