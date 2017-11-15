package com.blocket.tests;

import com.blocket.JSWaiter;
import com.blocket.WebDriverFactory;

import com.blocket.pages.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    public  void openSite() throws IOException {
        WebDriverFactory F = new WebDriverFactory();
        driver = F.getDriver();
        openMainPage();
    }

    public static WebDriver getDriver(){
        return WebDriverFactory.getDriver();
    }

     void openMainPage() throws IOException {

        Properties properties = new Properties();
        try(InputStream stream = getClass().getResourceAsStream("/url.properties")){
            properties.load(stream);
            driver.get( properties.getProperty("mainURI").toString() );
        }
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS );
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    static WebDriverWait wait;

    public  void waitForPageToLoad() {
        waitForElementInvisible();
        JSWaiter.setDriver(driver);
        JSWaiter.waitForJQueryLoad();
        JSWaiter.waitJQueryAngular();
        JSWaiter.waitUntilJSReady();

    }

    public void waitForElementInvisible(){
        MainPage mainPage = new MainPage(driver);
        wait = new WebDriverWait(driver, 800);
        wait.until(ExpectedConditions.invisibilityOf(mainPage.getBlocketImage()));
    }

}
