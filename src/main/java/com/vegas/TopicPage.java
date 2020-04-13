package com.vegas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopicPage {

    private By buttonCreateNewTopic = By.xpath("//button[text()='Новая тема']");
    private By topicNameInputLocator = By.xpath("//input[@placeholder = 'Заголовок темы']");
    private By descriptionTextInputLocator = By.id("editor-textarea");
    private By buttonPublishNewTopic = By.cssSelector(".btn.btn-primary.btn-sm.pull-right");



    private WebDriver driver;

    public TopicPage(WebDriver driver) {
        this.driver = driver;
    }

    public TopicPage clickCreateNewTopicButton() throws InterruptedException {
        WebElement element = driver.findElement(buttonCreateNewTopic);
        element.click();
        Thread.sleep(3000);
        System.out.println("I'm clickCreateNewTopicButton");
        return this;
    }

    public TopicPage inputTopicName(String nameTopic) {
        WebElement element = driver.findElement(topicNameInputLocator);
        element.sendKeys(nameTopic);
        System.out.println("I'm inputTopicName");
        return this;
    }

    public TopicPage inputDescriptionText(String descriptionText){
        WebElement element = driver.findElement(descriptionTextInputLocator);
        element.sendKeys(descriptionText);
        System.out.println("I'm inputDescriptionText");
        return this;
    }

    public TopicPage clickPublichNewTopic(){
        WebElement element = driver.findElement(buttonPublishNewTopic);
        element.click();
        System.out.println("I'm clickPublichNewTopic");
        return this;
    }

    public TopicPage getAlert(){
        driver.switchTo().alert().getText();
        return this;
    }
}
