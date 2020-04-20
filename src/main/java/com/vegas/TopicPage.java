package com.vegas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopicPage extends LoginStep {

    private By buttonCreateNewTopic = By.xpath("//button[text()='Новая тема']");
    private By buttonPublicNewTopic = By.xpath("//button[text()='Опубликовать тему']");
    private By buttonPreviewNewTopic = By.xpath("//button[text()='Предпросмотр']");
    private By buttonCancelNewTopic = By.xpath("//button[text()='Отмена']");
    private By buttonAnswerTheTopic = By.xpath("(//button[@class='btn btn-primary btn-block btn-outline'])[1]");
    private By buttonOpenTopic = By.xpath("(//div[@class='media-body']//a)[1]");
    private By buttonSendAnswer = By.xpath("//button[text() = 'Отправить ответ']");
    private By buttonCreateQuiz = By.xpath("(//button[text()='Добавить опрос'])[2]");
    private By buttonPublishNewQuiz = By.xpath("//button[text()='Сообщение с голосованием']");

    private By textPreviewNewTopic = By.cssSelector(".misago-markup p");
    private By textTopicTitle = By.cssSelector("div h1");
    private By textResponseMessage = By.xpath("(//article[@class='misago-markup'])[last()]");

    private By topicNameInputLocator = By.xpath("//input[@placeholder = 'Заголовок темы']");
    private By descriptionTextInputLocator = By.id("editor-textarea");
    private By locatorInputQuizQuestion = By.id("id_questions");
    private By locatorInputQuizAnswerOne = By.xpath("(//input[@placeholder='выбрать метку'])[1]");
    private By locatorInputQuizAnswerTwo = By.xpath("(//input[@placeholder='выбрать метку'])[2]");

    private By alert = By.cssSelector(".alert.alert-success");

    public TopicPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 10, 100);

    public TopicPage clickCreateNewTopicButton() {
        WebElement element = driver.findElement(buttonCreateNewTopic);
        element.click();
        System.out.println("I'm clickCreateNewTopicButton");
        return this;
    }

    public TopicPage inputTopicName(String nameTopic) {
        WebElement element = driver.findElement(topicNameInputLocator);
        element.sendKeys(nameTopic);
        System.out.println("I'm inputTopicName");
        return this;
    }

    public TopicPage inputDescriptionText(String descriptionText) {
        WebElement element = driver.findElement(descriptionTextInputLocator);
        element.sendKeys(descriptionText);
        System.out.println("I'm inputDescriptionText");
        return this;
    }

    public TopicPage clickPublicNewTopic() throws InterruptedException {
        WebElement element = driver.findElement(buttonPublicNewTopic);
        wait.until(ExpectedConditions.elementToBeClickable(buttonPublicNewTopic));
        Thread.sleep(1000);
        element.click();
        System.out.println("I'm clickPublishNewTopic");
        return this;
    }

    public String getAlert() {
        Alert alert = driver.switchTo().alert();
        String textToAlert = alert.getText();
        return textToAlert;
    }

    public TopicPage clickPreviewNewTopic() throws InterruptedException {
        WebElement element = driver.findElement(buttonPreviewNewTopic);
        element.click();
        Thread.sleep(1000);
        System.out.println("I'm clickPreviewNewTopic");
        return this;
    }

    public String assertTextTopicTitle() {
        WebElement element = driver.findElement(textTopicTitle);
        String assertText = element.getText();
        return assertText;
    }

    public String assertQuiz() throws InterruptedException {
        WebElement element = driver.findElement(alert);
        Thread.sleep(1000);
        String assertText = element.getText();
        return assertText;
    }

    public String assertTextPreviewNewTopic() {
        WebElement element = driver.findElement(textPreviewNewTopic);
        String assertText = element.getText();
        return assertText;
    }

    public String assertTextResponseMessage() {
        WebElement element = driver.findElement(textResponseMessage);
        String assertText = element.getText();
        return assertText;
    }

    public TopicPage clickCancelNewTopic() {
        WebElement element = driver.findElement(buttonCancelNewTopic);
        element.click();
        return this;
    }

    public TopicPage clickOpenTopic() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(buttonOpenTopic);
        element.click();
        return this;
    }

    public TopicPage clickAnswerTheTopic() {
        WebElement element = driver.findElement(buttonAnswerTheTopic);
        element.click();
        return this;
    }

    public TopicPage clickSendAnswer() throws InterruptedException {
        WebElement element = driver.findElement(buttonSendAnswer);
        element.click();
        Thread.sleep(1000);
        return this;
    }

    public TopicPage clickCreateQuiz() {
        WebElement element = driver.findElement(buttonCreateQuiz);
        element.click();
        return this;
    }

    public TopicPage inputTextQuestion(String questionText) {
        WebElement element = driver.findElement(locatorInputQuizQuestion);
        element.sendKeys(questionText);
        System.out.println("I'm inputTextQuestion");
        return this;
    }

    public TopicPage inputAnswerOne(String answerOneText) {
        WebElement element = driver.findElement(locatorInputQuizAnswerOne);
        element.sendKeys(answerOneText);
        System.out.println("I'm inputAnswerOne");
        return this;
    }

    public TopicPage inputAnswerTwo(String answerTwoText) {
        WebElement element = driver.findElement(locatorInputQuizAnswerTwo);
        element.sendKeys(answerTwoText);
        System.out.println("I'm inputAnswerTwo");
        return this;
    }

    public TopicPage clickPublishNewQuiz() throws InterruptedException {
        WebElement element = driver.findElement(buttonPublishNewQuiz);
        Thread.sleep(1000);
        element.click();
        System.out.println("I'm clickPublishNewQuiz");
        return this;
    }
}
