package com.dastancompany.driver;

import com.dastancompany.exception.FrameworkException;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver get(Modes mode, Map<String, Object> map) throws MalformedURLException {
        WebDriver driver = null;

        if (mode.equals(Modes.LOCAL)) {
            driver = new LocalDriverImpl().getDriver(map);
        } else if (mode.equals(Modes.BS)) {
            driver = new BrowserStackImpl().getDriver(map);
        } else if (mode.equals(Modes.SauceLabs)) {
            driver = new SauceLabsImpl().getDriver(map);
        } else {
            throw new FrameworkException("No cloud provider with the name you mentioned is configured");
        }
        return driver;
    }
}
