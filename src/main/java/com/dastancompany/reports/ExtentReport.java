package com.dastancompany.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public class ExtentReport {

    private static ExtentReports extent;


    public static void initReports() {
        if(extent==null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Checking");
            extent.attachReporter(spark);
        }
    }

    public static void tearDownReports() {
        if(extent!=null) {
            extent.flush();
            ThreadSafeExtentManager.unload();
        }
    }

    public static void createTest(String testcaseName) {

        ExtentTest test = extent.createTest(testcaseName);
        ThreadSafeExtentManager.setTest(test);
    }
}
