package com.bl.selenium.iframe;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.By;

public class Frames extends SeleniumBasicBase {

    public void frame() {
        try {
            webDriver.get("https://www.dezlearn.com/testingpage/");//get URL
            webDriver.switchTo().frame("do-it-iframe");//Switch to frame
            webDriver.findElement(By.xpath("//input[@type='search']")).sendKeys("hello");// input hello
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//input[@class='search-submit']")).click();//click on submit
            Thread.sleep(5000);
            webDriver.switchTo().defaultContent();//switch back to main page
            webDriver.findElement(By.xpath("//button[contains(text(),'Alert Box')]")).click();
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}