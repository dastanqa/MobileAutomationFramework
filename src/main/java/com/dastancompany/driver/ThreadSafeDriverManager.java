package com.dastancompany.driver;

import org.openqa.selenium.WebDriver;

public final class ThreadSafeDriverManager {
    private ThreadSafeDriverManager() {
    }

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static void unload(){
        driverThreadLocal.remove();
    }
}
