package com.vegas.test;

import com.vegas.MainPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterTest {

    private WebDriver driver;
    private String login;
    private String password;

    @Before
    public void prepareData() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.n7lanit.ru/");
    }

    @After
    public void clearData() {
        driver.quit();

    }

    @Given("User navigate to the login page")
    public void userNavigateToTheLoginPage() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openLoginPanel();
    }

    @And("^User enter for Login \"([^\"]*)\"$")
    public void userEnterForLogin(String login) throws Throwable {
        this.login = login;
        /*MainPage mainPage = new MainPage(driver);
        mainPage.inputLogin(login);*/
    }

    @And("^User enter for Password \"([^\"]*)\"$")
    public void userEnterForPassword(String password) throws Throwable {
        this.password = password;
        /*MainPage mainPage = new MainPage(driver);
        mainPage.inputLogin(password);*/
    }

    @And("User click login button")
    public void userClickLoginButton() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.enterLoginAndPassword(login, password);
    }

    @Then("User is enter")
    public void userIsEnter() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }

}
