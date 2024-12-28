package com.Logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//default logging level is info level
public class LogDemo {
    private Log logger = LogFactory.getLog(com.sprinbootDemo.jdbl_78_springboot.LogDemo.class);

    public void printLog(){
        logger.info("information is printed");
        logger.warn("warning is printed");
        logger.error("error is printed");
        logger.trace("trace is printed");
    }
}
