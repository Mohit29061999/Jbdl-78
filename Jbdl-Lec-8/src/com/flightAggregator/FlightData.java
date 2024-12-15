package com.flightAggregator;

import java.util.Date;

public class FlightData {
    String src;
    String desc;
    Date date;
    static int id =0;

    //which flight it is
    //String flight;
//    flight = "INDica";
    Flights flights;

    public FlightData(String src, String desc, Date date, Flights flights) {
        this.src = src;
        this.desc = desc;
        this.date = date;
        this.flights = flights;
        id++;

    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Flights getFlights() {
        return flights;
    }

    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "src='" + src + '\'' +
                ", desc='" + desc + '\'' +
                ", date=" + date +
                ", flights=" + flights +
                '}';
    }
}
