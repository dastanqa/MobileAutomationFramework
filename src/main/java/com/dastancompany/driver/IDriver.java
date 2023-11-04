package com.dastancompany.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;

public interface IDriver {
    //Interfaces gives you skeleton.
    public WebDriver getDriver(Map<String,Object>map) throws MalformedURLException;
}
