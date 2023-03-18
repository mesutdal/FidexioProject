package com.fidexio.stepDefinitions;

import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDef {

    LoginPage login = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }
    @When("enter username {string} and password {string}")
    public void enter_username_and_password(String username, String password) {
        login.inputUsername.sendKeys(username);
        login.inputPassword.sendKeys(password);
    }
    @When("user click on login button")
    public void user_click_on_login_button() {
        login.loginButton.click();
    }
    @Then("user should see discuss page")
    public void user_should_see_discuss_page() {
        BrowserUtils.verifyTitle("#Inbox - Odoo");
    }

    @Then("User should see“Wrong login password“ message.")
    public void userShouldSeeWrongLoginPasswordMessage() {
        Assert.assertTrue(login.wrongAlertMessage.isDisplayed());
        Assert.assertEquals("Wrong login/password", login.wrongAlertMessage.getText());
    }

    @Then("user should see the “Please fill out this field”message")
    public void userShouldSeeThePleaseFillOutThisFieldMessage() {
        login.inputUsername.getAttribute("validationMessage");
        login.inputPassword.getAttribute("validationMessage");
    }


    @Then("user should see the password in bullet signs")
    public void userShouldSeeThePasswordInBulletSigns() {
        Assert.assertTrue(login.inputPassword.getAttribute("type").equals("password"));
    }

    @And("user uses the Enter key on keyboard to log in")
    public void userUsesTheEnterKeyOnKeyboardToLogIn() {
        login.inputPassword.sendKeys(Keys.ENTER);
    }
}
