package com.dastancompany.pages;

import com.dastancompany.utils.DynamicXpathUtils;

public class ViewsLandingPageNative extends NativeBasePage {

    private String dragAndDrop = "//android.widget.TextView[contains(@text,'%s')]";

    public void clickMenuItem(String menuName) {
        String newXpath = DynamicXpathUtils.getXpath(dragAndDrop, menuName);

        click("xpath", newXpath, menuName);
    }
}
