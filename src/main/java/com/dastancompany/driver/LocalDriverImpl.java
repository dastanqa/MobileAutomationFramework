package com.dastancompany.driver;

import com.dastancompany.constants.FrameworkConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class LocalDriverImpl implements IDriver {

    @Override
    public WebDriver getDriver(Map<String, Object> map) throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(Platform.ANDROID.name())
                .setAutomationName("UIAutomator2")
                .setApp(FrameworkConstants.getInstance().getApkFilePath());

       map.forEach((k, v) -> options.setCapability(k, v));
//

        options.asMap().forEach((k, v) -> System.out.println(k + ":" + v));
        return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }
}
// DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.APP,
//                FrameworkConstants.getInstance().getApkFilePath());
//        map.forEach((k,v)->capabilities.setCapability(k,v));
//        //capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, map.get("port"));
//       // capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //to distinguish the platform //not mandatory
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Dastan Device");