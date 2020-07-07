package com.bl.selenium.multibrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {
    WebDriver driver = null;

    @Parameters("browserName")
    @BeforeTest
    public void setUp(String browserName) {
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("No such Browser");
        }
    }
    @Test
    public void browserTest() {
        driver.get("http://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Google", title);
    }

    @Test
    void browserTest2() {
        driver.get("http://www.youtube.com");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("YouTube", title);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
