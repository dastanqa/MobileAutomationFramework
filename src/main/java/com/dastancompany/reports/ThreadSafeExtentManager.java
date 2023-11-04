package com.dastancompany.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ThreadSafeExtentManager {
    private ThreadSafeExtentManager() {
    }

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return test.get();
    }

    static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    static void unload() {
        test.remove();
    }
}
