package com.vegas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private By buttonEnterLocator = By.cssSelector(".btn-sign-in");
    private By loginInputLocator = By.cssSelector("#id_username");
    private By passwordInputLocator = By.cssSelector("#id_password");
    private By buttonEnterLoginAndPasswordLocator = By.cssSelector("button.btn.btn-primary.btn-block");

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage openLoginPanel() throws InterruptedException {
        WebElement element = driver.findElement(buttonEnterLocator);
        Thread.sleep(2000);
        element.click();
        return this;
    }

    public MainPage inputLogin(String login) {
        WebElement element = driver.findElement(loginInputLocator);
        element.sendKeys(login);
        return this;
    }

    public MainPage inputPassword(String password) {
        WebElement element = driver.findElement(passwordInputLocator);
        element.sendKeys(password);
        return this;
    }

    public MainPage signIn() throws InterruptedException {
        WebElement element = driver.findElement(buttonEnterLoginAndPasswordLocator);
        Thread.sleep(2000);
        element.click();
        return this;
    }

    public MainPage enterLoginAndPassword(String login, String password) {
        //openLoginPanel();
        inputLogin(login);
        inputPassword(password);
        //signIn();
        return this;
    }

}
