package com.elevra.tests;

import com.elevra.base.BaseTest;
import com.elevra.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElevraSmokeTests extends BaseTest {

    public boolean waitForAppearingOfWebElement(WebElement element) {
        boolean text;
        try {
            new WebDriverWait(driver, Duration.ofMinutes(10)).
                    until(ExpectedConditions.visibilityOf(element));
            text = true;
        } catch (TimeoutException e) {
            text = false;
        }
        return text;
    }

    @Test(priority = 1)
    public void smokeTest1() throws InterruptedException {

        driver.get("https://qa.elevra.io/home");

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//a/h4[text()='Sign In']")));

        driver.findElement(new By.ByXPath("//a/h4[text()='Sign In']")).click();

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//input[@id='login-id']")));

        driver.findElement(new By.ByXPath("//input[@id='login-id']")).sendKeys("mydiningtestuser@place.com");

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button[text()='Continue']")));

        driver.findElement(new By.ByXPath("//button[text()='Continue']")).click();

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("(//input[@type='password'])[2]")));

        driver.findElement(new By.ByXPath("(//input[@type='password'])[2]")).sendKeys("Compass1!");

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button[text()='Login']")));

        driver.findElement(new By.ByXPath("//button[text()='Login']")).click();

        waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//h2[text()='Welcome MyDining Test User!']")));

        String welcomeUserText = driver.findElement(new By.ByXPath("//h2[text()='Welcome MyDining Test User!']")).getText();
        Assert.assertEquals("Welcome MyDining Test User!", welcomeUserText);

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();

        Assert.assertTrue(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).isDisplayed(), "Tray Tracking Main Menu isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//*[@aria-labelledby='Settings-nav-icon']")).isDisplayed(), " isn't displayed");

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Cart Loading']")));

        Assert.assertTrue(driver.findElement(new By.ByXPath("//button/p[text()='Cart Loading']")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//button/p[text()='Cart Departure']")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//button/p[text()='Cart in Transit']")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//button/p[text()='Tray Delivery']")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//button/p[text()='Tray Recovery']")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//button/p[text()='KDS']")).isDisplayed(), " isn't displayed");
    }

    @Test(priority = 2)
    public void smokeTest2() throws InterruptedException {
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Cart Loading']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Cart Loading']")).click();

        Assert.assertTrue(driver.findElement(new By.ByXPath("//h2[contains(text(), 'All Trays')]")).isDisplayed(), "All Trays Header isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='time-filter']//preceding-sibling::div[1]")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='search-filter']")).isDisplayed(), " isn't displayed");
    }

    @Test(priority = 3)
    public void smokeTest3() throws InterruptedException {
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Cart Departure']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Cart Departure']")).click();

        Assert.assertTrue(driver.findElement(new By.ByXPath("//h2[text()='Carts Departure']")).isDisplayed(), "Carts Departure Header isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='time-filter']//preceding-sibling::div[1]")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='search-filter']")).isDisplayed(), " isn't displayed");
    }

    @Test(priority = 4)
    public void smokeTest4() throws InterruptedException {
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Cart in Transit']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Cart in Transit']")).click();

        Assert.assertTrue(driver.findElement(new By.ByXPath("//h2[text()='Carts In Transit']")).isDisplayed(), "Carts In Transit header isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='time-filter']//preceding-sibling::div[1]")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='search-filter']")).isDisplayed(), " isn't displayed");
    }

    @Test(priority = 5)
    public void smokeTest5() throws InterruptedException {
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Delivery']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Delivery']")).click();

        Assert.assertTrue(driver.findElement(new By.ByXPath("//h2[text()='Tray Delivery']")).isDisplayed(), "Tray Delivery header isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='time-filter']//preceding-sibling::div[1]")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='search-filter']")).isDisplayed(), " isn't displayed");
    }

    @Test(priority = 6)
    public void smokeTest6() throws InterruptedException {
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Recovery']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Recovery']")).click();

        Assert.assertTrue(driver.findElement(new By.ByXPath("//h2[text()='Tray Recovery']")).isDisplayed(), "Tray Recovery header isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='time-filter']//preceding-sibling::div[1]")).isDisplayed(), " isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//input[@id='search-filter']")).isDisplayed(), " isn't displayed");
    }

    @Test(priority = 7)
    public void smokeTest7() throws InterruptedException {
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='KDS']")));

        Boolean isKDSButtonDisplayed = driver.findElement(new By.ByXPath("//button/p[text()='KDS']")).isDisplayed();

        Assert.assertTrue(isKDSButtonDisplayed, "KDS Button isn't displayed");


        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='KDS']")));
        driver.findElement(new By.ByXPath("//button/p[text()='KDS']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/child::*[text()='View Cart(s)']")));

        Boolean isViewCartsButtonButtonDisplayed = driver.findElement(new By.ByXPath("//button/child::*[text()='View Cart(s)']")).isDisplayed();

        Assert.assertTrue(isViewCartsButtonButtonDisplayed, "View Cart Button isn't displayed");
    }


    @Test(priority = 8)
    public void smokeTest8() throws InterruptedException {
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='KDS']")));
        driver.findElement(new By.ByXPath("//button/p[text()='KDS']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/child::*[text()='Filter']")));
        driver.findElement(new By.ByXPath("//button/child::*[text()='Filter']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//p[text()='FILTER']//following::input[@id='kds-search-filter']")));
        Thread.sleep(2000);

        Boolean isViewCartsButtonButtonDisplayed = driver.findElement(new By.ByXPath("//p[text()='FILTER']//following::input[@id='kds-search-filter']")).isDisplayed();
        Assert.assertTrue(isViewCartsButtonButtonDisplayed, "Search input field isn't displayed");

        Assert.assertTrue(driver.findElement(new By.ByXPath("//label[text()='DISPLAY']//following::*[text()='Tray Tickets']")).isDisplayed(), "Items Dropdown isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//label[text()='UNIT']//following::h4[text()='Show All ']")).isDisplayed(), "Unit Dropdown isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//label[text()='BUILD AREA']//following::h4[text()='Show All ']")).isDisplayed(), "Build Area Dropdown isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//button/p[text()='Cancel']")).isDisplayed(), "Cancel Button isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//button/p[text()='Apply']")).isDisplayed(), "Apply Button isn't displayed");

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Cancel']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Cancel']")).click();
    }

    @Test(priority = 9)
    public void smokeTest9() throws InterruptedException {

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='KDS']")));
        driver.findElement(new By.ByXPath("//button/p[text()='KDS']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//*[@aria-labelledby='Settings Icon']")));
        driver.findElement(new By.ByXPath("//*[@aria-labelledby='Settings Icon']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//h3[text()='Settings']")));

        Boolean isViewCartsButtonButtonDisplayed = driver.findElement(new By.ByXPath("//h3[text()='Settings']")).isDisplayed();

        Assert.assertTrue(isViewCartsButtonButtonDisplayed, "Setting header isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//*[text()='Number of Columns']//following::input[@value='3']")).isDisplayed(), "Number Of Columns Radio Button isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//*[text()='Number of Columns']//following::input[@value='4']")).isDisplayed(), "Number Of Columns Radio Button isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//*[text()='Number of Columns']//following::input[@value='5']")).isDisplayed(), "Number Of Columns Radio Button isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//*[text()='Number of Columns']//following::input[@value='6']")).isDisplayed(), "Number Of Columns Radio Button isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//*[text()='Number of Columns']//following::input[@value='Max that fits the screen (Recommended)']")).isDisplayed(), "Number Of Columns Radio Button isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//*[text()='Settings']//following::button/p[text()='Cancel']")).isDisplayed(), "Cancel Button isn't displayed");
        Assert.assertTrue(driver.findElement(new By.ByXPath("//*[text()='Settings']//following::button/p[text()='Apply']")).isDisplayed(), "Apply Button isn't displayed");

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//*[text()='Settings']//following::button/p[text()='Cancel']")));
        driver.findElement(new By.ByXPath("//*[text()='Settings']//following::button/p[text()='Cancel']")).click();
    }

    @Test(priority = 10)
    public void smokeTest90() throws InterruptedException {

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")));
        driver.findElement(new By.ByXPath("//button/p[text()='Tray Tracking']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/p[text()='KDS']")));
        driver.findElement(new By.ByXPath("//button/p[text()='KDS']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//button/child::*[text()='View Cart(s)']")));
        driver.findElement(new By.ByXPath("//button/child::*[text()='View Cart(s)']")).click();
        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//h3[text()='View Cart(s)']")));

        Boolean isViewCartsButtonButtonDisplayed = driver.findElement(new By.ByXPath("//h3[text()='View Cart(s)']")).isDisplayed();

        Assert.assertTrue(isViewCartsButtonButtonDisplayed, "View Carts isn't displayed");

        WaitUtils.waitForAppearingOfWebElement(driver.findElement(new By.ByXPath("//h3[text()='View Cart(s)']//following::button")));
        driver.findElement(new By.ByXPath("//h3[text()='View Cart(s)']//following::button")).click();
    }
}
