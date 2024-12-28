package com.sprinbootDemo.jdbl_78_springboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//default logging level is info level
public class LogDemo {
    private Log logger = LogFactory.getLog(LogDemo.class);

    public void printLog(){
        //insert a record in db
        //make an api call
        logger.info("information is printed");
        logger.warn("warning is printed");
        logger.error("error is printed");
        logger.trace("trace is printed");
    }
}
