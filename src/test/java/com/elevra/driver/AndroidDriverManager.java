package com.elevra.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public final class AndroidDriverManager {
    public static AndroidDriver driver;

    private AndroidDriverManager() {
    }

    public static AndroidDriver getDriver() throws Exception {
        return getDriver(
                "http://127.0.0.1:4723",
                "Android Emulator",
                "",
                "Chrome"
        );
    }

    public static AndroidDriver getDriver(
            String appiumServerUrl,
            String deviceName,
            String platformVersion,
            String browserName
    ) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", emptyToDefault(deviceName, "Android Emulator"));
        caps.setCapability("browserName", emptyToDefault(browserName, "Chrome"));
        caps.setCapability("chromedriverAutodownload", true);
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("newCommandTimeout", 120);

        if (platformVersion != null && !platformVersion.isBlank()) {
            caps.setCapability("platformVersion", platformVersion);
        }

        driver = new AndroidDriver(new URL(appiumServerUrl), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    private static String emptyToDefault(String value, String defaultValue) {
        return value == null || value.isBlank() ? defaultValue : value;
    }
}
