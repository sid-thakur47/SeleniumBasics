package com.bl.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HerokuAppNegativeTest {
    @Parameters( {"username", "password", "expectedMessage"})
    @Test(groups = {"negativeTest", "smokeTest"})
    public void negativeLoginTest(String userName, String password, String expectedMessage) {

        //create driver
        System.setProperty("webdriver.chrome.driver", "C:/Users/Shivani/Desktop/SelinumDemo/src/main/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        webDriver.get(url);

        //maximize window
        webDriver.manage().window().fullscreen();

        //verification
        String actualUrl = "http://the-internet.herokuapp.com/login";
        String expectedUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL do not match");

        //username
        WebElement userNameElement = webDriver.findElement(By.id("username"));
        userNameElement.sendKeys(userName);

        //password
        WebElement passwordElement = webDriver.findElement(By.id("password"));
        passwordElement.sendKeys(password);

        WebElement loginButton = webDriver.findElement(By.tagName("button"));
        loginButton.click();

        //verification for incorrect username
        WebElement errorMessageElement = webDriver.findElement(By.id("flash"));
        ;
        String actualMessage = errorMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        webDriver.quit();
    }

   /* @Test(groups = { "negativeTest"})
    public void passwordTest() {

        //create driver
        System.setProperty("webdriver.chrome.driver", "C:/Users/Shivani/Desktop/SelinumDemo/src/main/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        webDriver.get(url);

        //maximize window
        webDriver.manage().window().fullscreen();

        //verification
        String actualUrl = "http://the-internet.herokuapp.com/login";
        String expectedUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL do not match");

        //username
        WebElement userName = webDriver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        //password
        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("incorrectpassword");

        WebElement loginButton = webDriver.findElement(By.tagName("button"));
        loginButton.click();

        //verification for incorrect username
        WebElement errorMessage = webDriver.findElement(By.id("flash"));
        String expectedMessage = "Your password is invalid! ×";
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        webDriver.quit();
    }*/
}
