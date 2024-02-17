package com.tasy.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager intance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir") + "src/main/resources/config.properties";
    private Properties properties =  new Properties();

    public static PropertyManager getInstance(){
        if(intance == null){
            synchronized (lock){
                intance = new PropertyManager();
                intance.loadData();
            }
        }
        return intance;
    }
    private void loadData(){
        try{
            properties.load(new FileInputStream(propertyFilePath));
        }  catch (IOException e) {
            System.err.println("Class:PropertyManager | Method: loadData | Exception: " +e.getMessage());
        }
    }
    public String getProperty(String aproperty){
        return properties.getProperty(aproperty);
    }
}
