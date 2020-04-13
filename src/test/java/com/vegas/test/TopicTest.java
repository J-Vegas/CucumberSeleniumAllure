package com.vegas.test;

import com.vegas.MainPage;
import com.vegas.TopicPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.security.util.PendingException;

public class TopicTest {
    private WebDriver driver;
    private String nameTopic;
    private String textDescription;

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

    @Given("User is authorization")
    public void userIsAuthorization() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.signInAll("testforlanit", "qwe321zxc");
    }


    @And("User click the button Новая тема")
    public void userClickTheButton() throws InterruptedException {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.clickCreateNewTopicButton();

    }

    @And("User enters the name of the topic \"([^\"]*)\"$")
    public void userEntersTheNameOfTheTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }


    @And("User adds a description text \"([^\"]*)\"$")
    public void userAddsADescriptionText(String textDescription) {
        this.textDescription = textDescription;
    }

    @When("User click the button Опубликовать тему")
    public void userClickTheButtonPublicTopic() {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.inputTopicName(nameTopic);
        topicPage.inputDescriptionText(textDescription);
        topicPage.clickPublichNewTopic();
    }


    @Then("Topic created and published \"([^\"]*)\"$")
    public void topicCreatedAndPublished(String message) {
        TopicPage topicPage = new TopicPage(driver);
        TopicPage alertMessage = topicPage.getAlert();
        if (!alertMessage.equals(message)) {
            throw new PendingException();
        }
    }
}
