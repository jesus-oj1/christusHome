package com.tasy.framework.util.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class extentManager {

    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports creatExtentReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("./results/extent-report.html");
        reporter.config().setReportName("Test Execution Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Plataforma","Tasy");
        extentReports.setSystemInfo("Author","Luis Carlos Reyes Savage");
        return extentReports;
    }

}
