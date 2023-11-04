package com.dastancompany.constants;

import lombok.Getter;

import java.util.Objects;

@Getter
public final class FrameworkConstants {
    private FrameworkConstants() {
    }

    private static FrameworkConstants frameworkConstants;

    public static synchronized FrameworkConstants getInstance() {
        if (Objects.isNull(frameworkConstants)) {
            frameworkConstants = new FrameworkConstants();
        }
        return frameworkConstants;
    }

    private final String resourcesPath = System.getProperty("user.dir") + "/src/test/resources";
    private final String apkFilePath = resourcesPath + "/apkfiles/ApiDemos-debug.apk";
    private final String configFilePath = resourcesPath + "/config/config.properties";



}
