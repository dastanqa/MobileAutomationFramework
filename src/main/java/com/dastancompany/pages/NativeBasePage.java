package com.dastancompany.pages;

import com.dastancompany.driver.ThreadSafeDriverManager;
import com.dastancompany.reports.ExtentLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class NativeBasePage {

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected void click(WebElement element, String elementName) {
        explicitWait(element);
        element.click();

        ExtentLogger.pass(elementName + " has successfully been clicked");
    }

    private void explicitWait(WebElement element) {
        new WebDriverWait(ThreadSafeDriverManager.getDriver(), Duration.ofSeconds(5))
                .withMessage(() -> "Cannot locate the element")
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(element));

    }

    protected void click(By by, String elementName) {
        click(ThreadSafeDriverManager.getDriver().findElement(by), elementName);
    }

    protected void click(String locatorType, String value, String elementName) {
        if (locatorType.equalsIgnoreCase("xpath")) {
            click(By.xpath(value), elementName);
        } else if (locatorType.equalsIgnoreCase("id")) {
            click(By.id(value), elementName);
        }
    }

    protected void chooseItemAndClick(List<WebElement> list, String menu) {
        WebElement element = list.parallelStream()
                .filter(e -> e.getText().contains(menu))
                .findFirst().get();

        click(element, menu);

    }

    protected void scrollToSpecificElementCLick(By by) {

        while (ThreadSafeDriverManager.getDriver().findElements(by).isEmpty()) {

            Dimension dimension = ThreadSafeDriverManager.getDriver().manage().window().getSize();
            double screenHeightStart = dimension.getHeight() * 0.5;
            int scrollStart = (int) screenHeightStart;
            double screenHeightEnd = dimension.getHeight() * 0.2;
            int scrollEnd = (int) screenHeightEnd;

            int center = (int) (dimension.width * 0.5);
            new AndroidTouchAction((PerformsTouchActions) ThreadSafeDriverManager.getDriver())
                    .press(PointOption.point(center, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(center, scrollEnd)).release().perform();

        }

        if (!ThreadSafeDriverManager.getDriver().findElements(by).isEmpty()) {
            ThreadSafeDriverManager.getDriver().findElement(by).click();
        }


    }

    protected static void dragAndDrop(WebElement source, WebElement target) {
        new AndroidTouchAction((PerformsTouchActions) ThreadSafeDriverManager.getDriver()).longPress(LongPressOptions.longPressOptions()
                        .withDuration(Duration.ofSeconds(2)).withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
        System.out.println("Successfully Dragged and Dropped");
    }

    protected static void swipe(WebElement source, WebElement destination) {
        new AndroidTouchAction((PerformsTouchActions) ThreadSafeDriverManager.getDriver()).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(destination))
                .release()
                .perform();
    }

    protected static void longPress(WebElement element) {
        new AndroidTouchAction((PerformsTouchActions) ThreadSafeDriverManager.getDriver()).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(7))).perform();
    }

    protected static void performScrollUsingSequence(int startX, int startY, int endX, int endY) {
        Dimension dimension = ThreadSafeDriverManager.getDriver().manage().window().getSize();
        double screenHeightStart = dimension.getHeight() * 0.5;
        int scrollStart = (int) screenHeightStart;
        double screenHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = (int) screenHeightEnd;
        int center = (int) (dimension.width * 0.5);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center, scrollStart))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), center, scrollEnd))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        ((AppiumDriver) ThreadSafeDriverManager.getDriver()).perform(Collections.singletonList(sequence));
    }

    protected void tapUsingCordinates(int x, int y) {
        new AndroidTouchAction((PerformsTouchActions) ThreadSafeDriverManager.getDriver()).tap(PointOption.point(x, y)).perform();
    }

    protected void tap(WebElement element) {
        new AndroidTouchAction((PerformsTouchActions) ThreadSafeDriverManager.getDriver())
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(element)))
                .perform();
    }


}
