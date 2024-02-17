package com.tasy.framework.util.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log {
    private static final Logger log = LogManager.getLogger(com.tasy.framework.util.logs.log.class.getName());

    public static void info(String message){
        log.info(message);
    }
    public static void error(String message){
        log.error(message);
    }
    public static void warm(String message){
        log.warn(message);
    }
    public static void fatal(String message){
        log.fatal(message);
    }
    public static void debug(String message){
        log.debug(message);
    }
}
