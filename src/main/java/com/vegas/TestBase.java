package com.vegas;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;

    private By buttonEnterLocator = By.cssSelector(".btn-sign-in");
    private By loginInputLocator = By.cssSelector("#id_username");
    private By passwordInputLocator = By.cssSelector("#id_password");
    private By buttonEnterLoginAndPasswordLocator = By.cssSelector("button.btn.btn-primary.btn-block");

    public WebDriver getDriver() {
        return driver;
    }

    public void initialization() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.n7lanit.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("initialization");
    }

    public void closeBrowser() {
        driver.quit();
        System.out.println("closeBrowser");
    }

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
