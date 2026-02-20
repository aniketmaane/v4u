package com.elevra.utils;

import com.elevra.core.DriverContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitUtils {
    private WaitUtils() {
    }

    public static boolean waitForAppearingOfWebElement(WebElement element) {
        boolean text;
        try {
            new WebDriverWait(getDriver(), Duration.ofMinutes(10))
                    .until(ExpectedConditions.visibilityOf(element));
            text = true;
        } catch (TimeoutException e) {
            text = false;
        }
        return text;
    }

    private static WebDriver getDriver() {
        WebDriver driver = DriverContext.getDriver();
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Start the Appium driver before using WaitUtils.");
        }
        return driver;
    }
}
