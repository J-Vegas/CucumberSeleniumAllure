package com.vegas.test;

import com.vegas.TestBase;
import com.vegas.TopicPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import sun.security.util.PendingException;

public class TopicTest extends TestBase {

    private String nameTopic;
    private String textDescription;
    private String messageAlert;
    private String messageQuestion;
    private String messageOne;
    private String messageTwo;

    @Before
    public void prepareData() {
        initialization();
        System.out.println("prepareData");
    }

    @After
    public void clearData() {
        closeBrowser();
        System.out.println("clearData");
    }

    @Given("User is authorization")
    public void userIsAuthorization() throws InterruptedException {
        authorization("testforlanit", "qwe321zxc");
    }

    @And("User click the button Новая тема")
    public void userClickTheButton() throws InterruptedException {
        TopicPage topicPage = new TopicPage(getDriver());
        topicPage.clickCreateNewTopicButton();
    }

    @And("User enters the name of the topic \"([^\"]*)\"$")
    public void userEntersTheNameOfTheTopic(String nameTopic) {
        TopicPage topicPage = new TopicPage(getDriver());
        this.nameTopic = nameTopic;
        topicPage.inputTopicName(nameTopic);
    }

    @And("User adds a description text \"(.*)\"$")
    public void userAddsADescriptionText(String textDescription) {
        TopicPage topicPage = new TopicPage(getDriver());
        this.textDescription = textDescription;
        topicPage.inputDescriptionText(textDescription);
    }

    @When("User click the button Опубликовать тему")
    public void userClickTheButtonPublicTopic() throws InterruptedException {
        TopicPage topicPage = new TopicPage(getDriver());
        topicPage.clickPublichNewTopic();
    }

    @Then("Topic created and published")
    public void topicCreatedAndPublished() {
        TopicPage topicPage = new TopicPage(getDriver());
        Assert.assertEquals("New topic Vegas", topicPage.assertTextTopicTitle());
    }

    @Then("Topic created and published \"(.*)\"$")
    public void topicCreatedAndPublished(String messageAlert) {
        TopicPage topicPage = new TopicPage(getDriver());
        String alertMessage = topicPage.getAlert();
        if (!alertMessage.equals(messageAlert)) {
            throw new PendingException();
        }
    }

    @When("User click the button Предпросмотр")
    public void userClickTheButtonPreview() throws InterruptedException {
        TopicPage topicPage = new TopicPage(getDriver());
        topicPage.clickPreviewNewTopic();
    }

    @Then("Pop-up message appears Предпросмотр сообщения")
    public void popUpMessageAppearsMessagePreview() {
        TopicPage topicPage = new TopicPage(getDriver());
        Assert.assertEquals("New description", topicPage.assertTextPreviewNewTopic());
    }

    @When("User click the button Отмена")
    public void userClickTheButtonCancel() {
        TopicPage topicPage = new TopicPage(getDriver());
        topicPage.clickCancelNewTopic();
    }

    @And("User enters topic")
    public void userEntersTopic() throws InterruptedException {
        TopicPage topicPage = new TopicPage(getDriver());
        topicPage.clickOpenTopic();
    }

    @And("User click on the button Ответить")
    public void userClickOnTheButtonAnswer() throws InterruptedException {
        TopicPage topicPage = new TopicPage(getDriver());
        topicPage.clickAnswerTheTopic();
    }

    @When("User click the button Отправить ответ")
    public void userClickTheButtonSendAnswer() throws InterruptedException {
        TopicPage topicPage = new TopicPage(getDriver());
        topicPage.clickSendAnswer();
    }

    @Then("A response message appears in the subject")
    public void aResponseMessageAppearsInTheSubject() {
        TopicPage topicPage = new TopicPage(getDriver());
        Assert.assertEquals("New description's answer", topicPage.assertTextResponseMessage());
    }

    @And("User click the button Добавить опрос")
    public void userClickTheButtonCreateQuiz() throws InterruptedException {
        TopicPage topicPage = new TopicPage(getDriver());
        topicPage.clickCreateQuiz();
    }

    @And("User add answer options \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userAddAnswerOptions(String messageOne, String messageTwo) {
        TopicPage topicPage = new TopicPage(getDriver());
        this.messageOne = messageOne;
        this.messageTwo = messageTwo;
        topicPage.inputAnswerOne(messageOne);
        topicPage.inputAnswerTwo(messageTwo);
    }

    @And("User add quiz question \"([^\"]*)\"$")
    public void userAddQuizQuestion(String messageQuestion) {
        TopicPage topicPage = new TopicPage(getDriver());
        this.messageQuestion = messageQuestion;
        topicPage.inputTextQuestion(messageQuestion);
    }

    @When("User click the button Сообщение с голосованием")
    public void userClickTheButtonQuiz() throws InterruptedException {
        TopicPage topicPage = new TopicPage(getDriver());
        topicPage.clickPublishNewQuiz();
    }

    @Then("Pop-up message appears \"([^\"]*)\"$")
    public void popUpMessageAppearsQuiz(String messageAlert) {
        TopicPage topicPage = new TopicPage(getDriver());
        this.messageAlert = messageAlert;
        Assert.assertEquals(messageAlert, topicPage.assertQuiz());
    }
}
