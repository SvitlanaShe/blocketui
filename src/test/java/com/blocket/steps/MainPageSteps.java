package com.blocket.steps;

import com.blocket.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {
    public WebDriver driver;
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
    }

    public void clickLink(String link) throws IllegalMonitorStateException {
        mainPage.clickLink(link);

    }

}
