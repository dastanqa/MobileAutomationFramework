package com.dastancompany.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.dastancompany.driver.Driver;
import com.dastancompany.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Map;

public class BaseTest {


    @BeforeMethod
    public void setUpTest(Object[] data) throws MalformedURLException {

        Map<String,Object> map = (Map<String, Object>) data[0];
        System.out.println(data[0]);
        Driver.initDriver(map);

    }

    @AfterMethod
    public void tearDownTest() {
        Driver.quitDriver();


    }

}
