package com.blocket.steps;

import com.blocket.pages.LoginPage;

import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }
    public void enterLogin(String login) {
        loginPage.loginInput.sendKeys(login);
    }
    public void enterPassword(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginPage.loginButton.click();
    }

    public String getErrorMessage() {
        return loginPage.errorMessage.getText();
    }
}
