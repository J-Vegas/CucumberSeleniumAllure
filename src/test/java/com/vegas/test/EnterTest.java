package com.vegas.test;

import com.vegas.MainPage;
import com.vegas.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class EnterTest extends TestBase {

    private String login;
    private String password;

    @Before
    public void prepareData() {
        initialization();
    }

    @After
    public void clearData() {
        closeBrowser();
    }

    @Given("User navigate to the login page")
    public void userNavigateToTheLoginPage() throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.openLoginPanel();
    }

    @And("^User enter for Login \"([^\"]*)\"$")
    public void userEnterForLogin(String login) {
        this.login = login;
    }

    @And("^User enter for Password \"([^\"]*)\"$")
    public void userEnterForPassword(String password) {
        this.password = password;
    }

    @And("User click login button")
    public void userClickLoginButton() throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.enterLoginAndPassword(login, password);
    }

    @Then("User is enter")
    public void userIsEnter() throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.signIn();
    }
}
