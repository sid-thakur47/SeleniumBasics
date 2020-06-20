package com.bl.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {

    @Test
    public void loginTest() {
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
        password.sendKeys("SuperSecretPassword!");

        WebElement loginButton = webDriver.findElement(By.tagName("button"));
        loginButton.click();


        //logout
        WebElement logoutButton = webDriver.findElement(By.xpath("//a[@class='button secondary radius']"));
        logoutButton.click();

        //success message
        WebElement successMessage = webDriver.findElement(By.cssSelector("div#flash"));
        successMessage.isDisplayed();

        //close browser
        webDriver.quit();
    }
}
