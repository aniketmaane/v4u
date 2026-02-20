package com.elevra.core;

import io.appium.java_client.AppiumDriver;

public final class DriverContext {
    private static final ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<>();

    private DriverContext() {
    }

    public static void setDriver(AppiumDriver driver) {
        DRIVER.set(driver);
    }

    public static AppiumDriver getDriver() {
        return DRIVER.get();
    }

    public static void unload() {
        DRIVER.remove();
    }
}
