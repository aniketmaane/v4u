package com.elevra.driver;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public final class IPadDriverManager {
    public static IOSDriver driver;

    private IPadDriverManager() {
    }

    public static IOSDriver getDriver() throws Exception {
        return getDriver(
                "http://127.0.0.1:4723",
                "iPad Air 13-inch (M3)",
                "26.2",
                "Safari"
        );
    }

    public static IOSDriver getDriver(
            String appiumServerUrl,
            String deviceName,
            String platformVersion,
            String browserName
    ) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("deviceName", emptyToDefault(deviceName, "iPad Air 13-inch (M3)"));
        caps.setCapability("platformVersion", emptyToDefault(platformVersion, "26.2"));
        caps.setCapability("browserName", emptyToDefault(browserName, "Safari"));

        caps.setCapability("safariAllowPopups", true);
        caps.setCapability("safariIgnoreFraudWarning", true);
        caps.setCapability("autoAcceptAlerts", true);
        caps.setCapability("includeSafariInWebviews", true);

        driver = new IOSDriver(new URL(appiumServerUrl), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    private static String emptyToDefault(String value, String defaultValue) {
        return value == null || value.isBlank() ? defaultValue : value;
    }
}
