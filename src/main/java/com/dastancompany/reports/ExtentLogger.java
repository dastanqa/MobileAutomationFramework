package com.dastancompany.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.dastancompany.utils.ScreenshotUtils;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        ThreadSafeExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        //ThreadSafeExtentManager.getExtentTest().fail(message);
        ThreadSafeExtentManager.getExtentTest().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64()).build());
    }

    public static void info(String message) {
        ThreadSafeExtentManager.getExtentTest().info(message);
    }

    public static void skip(String message) {
        ThreadSafeExtentManager.getExtentTest().skip(message);
    }


}
