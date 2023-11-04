package com.dastancompany.pages;

import com.dastancompany.driver.ThreadSafeDriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageNative extends NativeBasePage {

    //Page Factory
    //By Locators
    //String locators


    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Views')]")
    private WebElement views;

    @AndroidFindBy(xpath = "//android.widgets.TextView")
    private List<WebElement> menuitems;

    public HomePageNative() {
        PageFactory.initElements(new AppiumFieldDecorator(ThreadSafeDriverManager.getDriver()), this);


    }


    public ViewsLandingPageNative clickOnViews() {
        click(views, "Views");
        return new ViewsLandingPageNative();
    }

    public void clickAMenuItem(String menu) {

        chooseItemAndClick(menuitems, menu);
    }
}
