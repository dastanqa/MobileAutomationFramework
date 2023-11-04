package com.dastancompany.listeners;

import com.dastancompany.reports.ExtentLogger;
import com.dastancompany.reports.ExtentReport;
import org.testng.*;

public class ListenersClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.tearDownReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName()+" has passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName()+" has failed miserably");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName()+" has skipped unfortunately");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
