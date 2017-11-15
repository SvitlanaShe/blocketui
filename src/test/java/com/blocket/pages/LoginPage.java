package com.blocket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "CredIdentifier")
    public WebElement loginInput;

    @FindBy(id = "CredPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@class='btn btn-primary']" )
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='bd alert-info']/p")
    public WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
