package com.vegas.test;

import com.vegas.Hook;
import com.vegas.MainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class EnterTest {

    private String login;
    private String password;

    @Given("User navigate to the login page")
    public void userNavigateToTheLoginPage() {
        MainPage mainPage = new MainPage(Hook.Driver);
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
    public void userClickLoginButton() {
        MainPage mainPage = new MainPage(Hook.Driver);
        mainPage.enterLoginAndPassword(login, password);
    }

    @Then("User is enter")
    public void userIsEnter() {
        MainPage mainPage = new MainPage(Hook.Driver);
        mainPage.signIn();
    }
}
