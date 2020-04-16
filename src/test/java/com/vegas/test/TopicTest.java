package com.vegas.test;

import com.vegas.MainPage;
import com.vegas.TopicPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.security.util.PendingException;

public class TopicTest {
    private WebDriver driver;
    private String nameTopic;
    private String textDescription;
    private String messageAlert;
    private String messageQuestion;
    private String messageOne;
    private String messageTwo;

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
        TopicPage topicPage = new TopicPage(driver);
        this.nameTopic = nameTopic;
        topicPage.inputTopicName(nameTopic);
    }

    @And("User adds a description text \"(.*)\"$")
    public void userAddsADescriptionText(String textDescription) {
        TopicPage topicPage = new TopicPage(driver);
        this.textDescription = textDescription;
        topicPage.inputDescriptionText(textDescription);
    }

    @When("User click the button Опубликовать тему")
    public void userClickTheButtonPublicTopic() throws InterruptedException {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.clickPublichNewTopic();
    }

    @Then("Topic created and published")
    public void topicCreatedAndPublished() {
        TopicPage topicPage = new TopicPage(driver);
        Assert.assertEquals("New topic Vegas", topicPage.assertTextTopicTitle());
    }

    @Then("Topic created and published \"(.*)\"$")
    public void topicCreatedAndPublished(String messageAlert) {
        TopicPage topicPage = new TopicPage(driver);
        String alertMessage = topicPage.getAlert();
        if (!alertMessage.equals(messageAlert)) {
            throw new PendingException();
        }
    }

    @When("User click the button Предпросмотр")
    public void userClickTheButtonPreview() throws InterruptedException {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.clickPreviewNewTopic();
    }

    @Then("Pop-up message appears Предпросмотр сообщения")
    public void popUpMessageAppearsMessagePreview() {
        TopicPage topicPage = new TopicPage(driver);
        Assert.assertEquals("New description", topicPage.assertTextPreviewNewTopic());
    }

    @When("User click the button Отмена")
    public void userClickTheButtonCancel() {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.clickCancelNewTopic();
    }

    @And("User enters topic")
    public void userEntersTopic() throws InterruptedException {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.clickOpenTopic();
    }

    @And("User click on the button Ответить")
    public void userClickOnTheButtonAnswer() throws InterruptedException {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.clickAnswerTheTopic();
    }

    @When("User click the button Отправить ответ")
    public void userClickTheButtonSendAnswer() throws InterruptedException {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.clickSendAnswer();
    }

    @Then("A response message appears in the subject")
    public void aResponseMessageAppearsInTheSubject() {
        TopicPage topicPage = new TopicPage(driver);
        Assert.assertEquals("New description's answer", topicPage.assertTextResponseMessage());
    }

    @And("User click the button Добавить опрос")
    public void userClickTheButtonCreateQuiz() throws InterruptedException {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.clickCreateQuiz();
    }

    @And("User add answer options \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userAddAnswerOptions(String messageOne, String messageTwo) {
        TopicPage topicPage = new TopicPage(driver);
        this.messageOne = messageOne;
        this.messageTwo = messageTwo;
        topicPage.inputAnswerOne(messageOne);
        topicPage.inputAnswerTwo(messageTwo);
    }

    @And("User add quiz question \"([^\"]*)\"$")
    public void userAddQuizQuestion(String messageQuestion) {
        TopicPage topicPage = new TopicPage(driver);
        this.messageQuestion = messageQuestion;
        topicPage.inputTextQuestion(messageQuestion);
    }

    @When("User click the button Сообщение с голосованием")
    public void userClickTheButtonQuiz() throws InterruptedException {
        TopicPage topicPage = new TopicPage(driver);
        topicPage.clickPublishNewQuiz();
    }

    @Then("Pop-up message appears \"([^\"]*)\"$")
    public void popUpMessageAppearsQuiz(String messageAlert) {
        TopicPage topicPage = new TopicPage(driver);
        this.messageAlert = messageAlert;
        Assert.assertEquals(messageAlert, topicPage.assertQuiz());
    }
}
