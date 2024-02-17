package com.tasy.framework.util.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.util.HashMap;
import java.util.Map;
public class extentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = extentManager.creatExtentReports();
    public static synchronized ExtentTest getTest(){
        return extentTestMap.get((int) Thread.currentThread().getId());
    }
    public static synchronized ExtentTest starTest(String testName,String desc){
        ExtentTest test = extent.createTest(testName,desc);
        extentTestMap.put((int)Thread.currentThread().getId(), test);
        return test;
    }
}
