package com.vegas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends TestBase {
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
        //Thread.sleep(2000);
        element.click();
        System.out.println("I'm openLoginPanel");
        return this;
    }

    public MainPage inputLogin(String login) {
        WebElement element = driver.findElement(loginInputLocator);
        element.sendKeys(login);
        System.out.println("I'm inputLogin");
        return this;
    }

    public MainPage inputPassword(String password) {
        WebElement element = driver.findElement(passwordInputLocator);
        element.sendKeys(password);
        System.out.println("I'm inputPassword");
        return this;
    }

    public MainPage signIn() throws InterruptedException {
        WebElement element = driver.findElement(buttonEnterLoginAndPasswordLocator);
        //Thread.sleep(2000);
        element.click();
        System.out.println("I'm signIn");
        return this;
    }

    public MainPage enterLoginAndPassword(String login, String password) throws InterruptedException {
        //Thread.sleep(1000);
        inputLogin(login);
        inputPassword(password);
        System.out.println("I'm enterLoginAndPassword");
        return this;
    }
}
