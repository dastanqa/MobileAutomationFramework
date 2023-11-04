package com.dastancompany.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserStackImpl implements IDriver{
    @Override
    public WebDriver getDriver(Map<String,Object>map) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", "playboypubg_qAdUxV");
        capabilities.setCapability("browserstack.key", "usEQq1et4SAuGLNEnz7K");
        capabilities.setCapability(MobileCapabilityType.APP, "bs://53e13d7668eef9441a4f49a46e4a1b0ddd3380ff");
        capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("os_version", "12.0");
        capabilities.setCapability("project", "Test Java Project");
        capabilities.setCapability("build", "Java Android Demo");

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //to distinguish the platform //not mandatory

        return new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
    }
}
