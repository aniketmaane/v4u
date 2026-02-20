package com.elevra.base;

import com.elevra.core.DriverContext;
import com.elevra.driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    protected AppiumDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"platformName", "browserName", "appiumServerUrl", "deviceName", "platformVersion"})
    public void setUp(
            @Optional("android") String platformName,
            @Optional("chrome") String browserName,
            @Optional("http://127.0.0.1:4723") String appiumServerUrl,
            @Optional("") String deviceName,
            @Optional("") String platformVersion
    ) throws Exception {
        String resolvedPlatformName = System.getProperty("platformName", platformName);
        String resolvedBrowserName = System.getProperty("browserName", browserName);
        String resolvedAppiumServerUrl = System.getProperty("appiumServerUrl", appiumServerUrl);
        String resolvedDeviceName = System.getProperty("deviceName", deviceName);
        String resolvedPlatformVersion = System.getProperty("platformVersion", platformVersion);

        driver = DriverFactory.createDriver(
                resolvedPlatformName,
                resolvedBrowserName,
                resolvedAppiumServerUrl,
                resolvedDeviceName,
                resolvedPlatformVersion
        );
        DriverContext.setDriver(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        DriverContext.unload();
    }
}
