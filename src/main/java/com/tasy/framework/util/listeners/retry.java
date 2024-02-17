package com.tasy.framework.util.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {
    private byte count = 0;
    private static byte maxTry = 1;
    public boolean retry(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            if(count < maxTry){
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        }
        return false;
    }

    //public void extendReportsFailOperation(ITestRsult){
      //  System.out.println(iTestResult.getStatus());

    //}
}
