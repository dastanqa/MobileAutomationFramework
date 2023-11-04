package com.dastancompany.utils;

import com.dastancompany.driver.ThreadSafeDriverManager;
import com.dastancompany.reports.ThreadSafeExtentManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {
    private ScreenshotUtils() {
    }

    public static String getBase64() {
        return ((TakesScreenshot) ThreadSafeDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }


}
