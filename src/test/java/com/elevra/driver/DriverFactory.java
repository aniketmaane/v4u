package com.elevra.driver;

import io.appium.java_client.AppiumDriver;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static AppiumDriver createDriver(
            String platformName,
            String browserName,
            String appiumServerUrl,
            String deviceName,
            String platformVersion
    ) throws Exception {
        if ("ios".equalsIgnoreCase(platformName)) {
            return IPadDriverManager.getDriver(
                    appiumServerUrl,
                    deviceName,
                    platformVersion,
                    browserName
            );
        }

        if ("android".equalsIgnoreCase(platformName)) {
            return AndroidDriverManager.getDriver(
                    appiumServerUrl,
                    deviceName,
                    platformVersion,
                    browserName
            );
        }

        throw new IllegalArgumentException("Unsupported platformName: " + platformName + ". Use ios or android.");
    }
}
