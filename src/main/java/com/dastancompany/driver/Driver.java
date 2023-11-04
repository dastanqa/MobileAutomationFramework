package com.dastancompany.driver;

import com.dastancompany.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.Objects;

public final class Driver {




    private Driver() {
    }

    public static void initDriver(Map<String,Object>map) throws MalformedURLException {

        if(Objects.isNull(ThreadSafeDriverManager.getDriver())) {
            String modeValue = PropertyUtils.getValue("mode");
            WebDriver driver = DriverFactory.get(Modes.valueOf(modeValue.toUpperCase()),map);
            ThreadSafeDriverManager.setDriver(driver);
        }
    }

    public static void quitDriver() {
        //
        if(Objects.nonNull(ThreadSafeDriverManager.getDriver())) {
            ThreadSafeDriverManager.getDriver().quit();
            ThreadSafeDriverManager.unload();
        }
    }
}
