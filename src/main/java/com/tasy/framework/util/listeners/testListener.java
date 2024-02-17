package com.tasy.framework.util.listeners;

import com.tasy.framework.util.extentreports.extentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static com.tasy.framework.util.logs.log.info;

public class testListener implements ITestListener {
    private static String getTestMethodName (ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext context){
        info("Starting mehtod: " +context.getName());

    }

    @Override
    public void onFinish(ITestContext context){
        info("Finish method "+ context.getName());
        info("XXXXXXXXXXXXXXXXXXX     -E--N--D     XXXXXXXXXXXXXXXXXXX");
        extentManager.extentReports.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result){
        info(getTestMethodName(result) + "test is succed.");
    }
}
