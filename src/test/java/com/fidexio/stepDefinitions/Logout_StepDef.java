package com.fidexio.stepDefinitions;

import com.fidexio.pages.LoginPage;
import com.fidexio.pages.LogoutPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_StepDef {

    LoginPage login = new LoginPage();
    LogoutPage logout = new LogoutPage();

    @Given("user opens a browser and goes to login page")
    public void user_opens_a_browser_and_goes_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        login.loginMethod();
    }
    @Given("user on the discuss page")
    public void user_logs_in_and_on_the_home_page() {
        BrowserUtils.verifyTitle("#Inbox - Odoo");
    }
    @When("User clicks profile name")
    public void userClicksProfileName() {
        logout.profileMenu.click();

    }

    @And("User clicks the Log out button.")
    public void userClicksTheButton() {
        logout.logoutOption.click();
    }

    @Then("User lands on the login page")
    public void userLandsOnTheLoginPage() {
        BrowserUtils.verifyTitle("Login | Best solution for startups");
    }

    @And("User clicks go back button on login page")
    public void userClicksGoBackButtonOnLoginPage() {
        Driver.getDriver().navigate().back();
    }

    @Then("User can not access the home page again")
    public void userCanNotAccessTheHomePageAgain() {
        Assert.assertTrue(logout.expiredAlert.isDisplayed());
    }
}



