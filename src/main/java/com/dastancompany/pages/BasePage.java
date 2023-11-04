package com.dastancompany.pages;

import org.openqa.selenium.WebElement;

public interface BasePage {
    public abstract void click(WebElement element,String elementName);
    void scrollDown(WebElement element);
}
