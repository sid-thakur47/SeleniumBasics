package com.bl.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver webDriver;

    @BeforeMethod
    private void setup() {
        //create driver
        System.setProperty("webdriver.chrome.driver", "C:/Users/Shivani/Desktop/SelinumDemo/src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        webDriver.get(url);

        //maximize window
        webDriver.manage().window().fullscreen();

        String title = webDriver.getTitle();
        System.out.println(title);
    }

    @AfterMethod(alwaysRun = true)
    private void closeBrowser() {
        //close browser
        webDriver.quit();
    }
    @Parameters( {"username", "password","expectedMessage"})
    @Test(priority = 1, groups = {"positiveTest", "smokeTest"})
    public void positiveLoginTest(String username,String password,String expectedMessage) {

        //verification
        String actualUrl = "http://the-internet.herokuapp.com/login";
        String expectedUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL do not match");

        //username
        WebElement usernameElement = webDriver.findElement(By.id("username"));
        usernameElement.sendKeys(username);

        //password
        WebElement passwordElement = webDriver.findElement(By.id("password"));
        passwordElement.sendKeys(password);

        WebElement loginButton = webDriver.findElement(By.tagName("button"));
        loginButton.click();

        //success message
        WebElement successMessage = webDriver.findElement(By.cssSelector("div#flash"));
        successMessage.isDisplayed();

        WebElement errorMessageElement = webDriver.findElement(By.id("flash-messages"));
        String actualMessage = errorMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        //logout
        WebElement logoutButton = webDriver.findElement(By.xpath("//a[@class='button secondary radius']"));
        logoutButton.click();


    }

    @Parameters( {"username", "password", "expectedMessage"})
    @Test(priority = 2, groups = {"negativeTest", "smokeTest"})
    public void negativeLoginTest(String userName, String password, String expectedMessage) {

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
        String actualMessage = errorMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
