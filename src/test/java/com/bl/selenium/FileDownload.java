package com.bl.selenium;

import com.bl.selenium.base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FileDownload extends Base {
    File folder;
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh-mm-ss");
        String time = dateFormat.format(now);
        WebDriverManager.chromedriver().setup();
        folder = new File(time);
        folder.mkdir();
        ChromeOptions options = new ChromeOptions();
        Map<String,Object> pref = new HashMap<>();
        pref.put("profile.default_content_settings.popups", 0);
        pref.put("download.default_directory", folder.getAbsolutePath());
        options.setExperimentalOption("prefs", pref);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
    }
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[contains(text(),'filler.txt')]")).click();
        Thread.sleep(5000);
        File[] files = folder.listFiles();
        Assert.assertTrue(files.length > 0);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        for(File file: folder.listFiles()){
            file.delete();
        }
    }
}
