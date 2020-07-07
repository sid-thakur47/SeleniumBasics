package com.bl.selenium.multibrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

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
        Assert.assertEquals("Google",title);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
