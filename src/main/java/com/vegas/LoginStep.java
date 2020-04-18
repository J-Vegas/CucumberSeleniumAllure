package com.vegas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginStep {

    public WebDriver driver;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
    }

    private By buttonEnterLocator = By.cssSelector(".btn-sign-in");
    private By loginInputLocator = By.cssSelector("#id_username");
    private By passwordInputLocator = By.cssSelector("#id_password");
    private By buttonEnterLoginAndPasswordLocator = By.cssSelector("button.btn.btn-primary.btn-block");


    public void authorization(String login, String password) throws InterruptedException {
        WebElement element = driver.findElement(buttonEnterLocator);
        element.click();
        element = driver.findElement(loginInputLocator);
        element.sendKeys(login);
        element = driver.findElement(passwordInputLocator);
        element.sendKeys(password);
        element = driver.findElement(buttonEnterLoginAndPasswordLocator);
        Thread.sleep(2000);
        element.click();
    }
}
