package com.tasy.framework.base;

import static com.tasy.framework.util.logs.log.error;

public class FrameWorkException extends Exception {
    public static final long serialVersiónUID = 700L;
    public FrameWorkException() {}
    public FrameWorkException(String mesage){
        super(mesage);
        error(mesage);
    }
    public FrameWorkException(String mesage,Exception e){
        this(mesage);
        error(e.getMessage());
    }
}
