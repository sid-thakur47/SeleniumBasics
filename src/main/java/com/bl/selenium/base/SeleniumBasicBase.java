package com.bl.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SeleniumBasicBase {

    public static ChromeDriver webDriver;//instance of Chrome driver
    public static Properties properties;//instance of properties

    //initialization and loading of file to access private data
    public SeleniumBasicBase() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("C:/Users/Shivani/Desktop/Backup/Input.csv");
            properties.load(input);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //initialization of chrome browser
    public static void initializeBase() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
    }
}
