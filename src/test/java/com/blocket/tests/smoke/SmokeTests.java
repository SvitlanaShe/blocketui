package com.blocket.tests.smoke;
import com.blocket.steps.LoginSteps;
import com.blocket.steps.MainPageSteps;
import com.blocket.tests.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import java.io.IOException;

public class SmokeTests extends BaseTest {
    WebDriver driver = getDriver();
    MainPageSteps mainPage = new MainPageSteps(driver);
    LoginSteps loginSteps = new LoginSteps(driver);

    @AfterSuite
    public void shutDown(){
        if(driver!=null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    @Given("on main page")
    public void on_main_page() throws IOException, InterruptedException {
        openSite();
    }

    @When("^wait for page to be loaded$")
    public void wait_for_page_to_be_downoaded() throws Throwable {
        waitForPageToLoad();
    }


    @Then("^title is \"([^\"]*)\"$")
    public void title_is(String title) throws Throwable {
        Assert.assertTrue(driver.getTitle().contains(title),
                " Titles mismuch! " + driver.getTitle()+
        " does not contain " + title);
    }

    @When("^click on top link \"(.*)\"$")
    public void click_on_top_link(String navlink) throws Throwable {
        mainPage.clickLink(navlink);
    }

    @Then("^url \"(.*)\" is opened$")
    public void url_is_opened(String navurl) throws Throwable {

        Assert.assertTrue(getCurrentURL().contains(navurl),
                "URL is not as expected "+
                        getCurrentURL() + " does not contains " +
                        navurl);
    }

    @And("^enter login \"([^\"]*)\"$")
    public void enter_login(String login) throws Throwable {
        loginSteps.enterLogin(login);
    }

    @And("^enter password \"([^\"]*)\"$")
    public void enter_password(String password) throws Throwable {
        loginSteps.enterPassword(password);
    }

    @And("^click login button$")
    public void click_login_button() throws Throwable {
        loginSteps.clickLoginButton();
    }

    @Then("^verify Error message \"([^\"]*)\"$")
    public void verify_Error_message(String errorMessage) throws Throwable {
        Assert.assertTrue(loginSteps.getErrorMessage().contains(errorMessage)
                , "error message mismatch ");
    }

}
