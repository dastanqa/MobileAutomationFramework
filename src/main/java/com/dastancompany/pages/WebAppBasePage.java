package com.dastancompany.pages;

import com.dastancompany.reports.ExtentLogger;
import org.openqa.selenium.WebElement;

public class WebAppBasePage {

    protected void click(WebElement element,String elementName){
        element.click();
        ExtentLogger.pass(elementName+" is clicked successfully");
    }
}
