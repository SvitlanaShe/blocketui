package com.blocket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    WebDriver driver;
    WebDriverWait wait ;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//nav[@role='navigation']//a")
    List<WebElement> topNavigationLinks;

    public By blocketImageBy = By.xpath("//div[@id='blocket_header']//*[contains(@href,'https://www.blocket.se')]");


    public void clickLink(String link) {
        driver.findElement(By.linkText(link)).click();
  }

    public WebElement getBlocketImage() {
        return  driver.findElement(blocketImageBy);
    }

}
