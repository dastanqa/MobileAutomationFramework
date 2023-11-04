package com.dastancompany.pages;

import com.dastancompany.driver.ThreadSafeDriverManager;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPageNative extends NativeBasePage {

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private WebElement dot1;
    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_2")
    private WebElement dot12;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_result_text")
    private WebElement droppedResult;

    public DragAndDropPageNative(){
        PageFactory.initElements(new AppiumFieldDecorator(ThreadSafeDriverManager.getDriver()),this);
    }
    public DragAndDropPageNative perforDragDrop(){
        dragAndDrop(dot1,dot12);
        return this;
    }

    public String getSuccessMessage(){
        return getText(droppedResult);
    }
}
