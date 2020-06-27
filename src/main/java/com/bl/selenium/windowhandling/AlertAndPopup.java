package com.bl.selenium.windowhandling;

import com.bl.selenium.base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertAndPopup extends Base {

    public void clickAlert() {
        try {
            webDriver.get("http://the-internet.herokuapp.com/javascript_alerts");
            WebElement element = webDriver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
            element.click();
            Thread.sleep(1000);
            Alert alert = webDriver.switchTo().alert();
            Thread.sleep(1000);
            String alertMessage = webDriver.switchTo().alert().getText();
            System.out.println(alertMessage);
            alert.accept();
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickOkAndCancelAlert() {
        try {
            webDriver.get("http://the-internet.herokuapp.com/javascript_alerts");
            WebElement element = webDriver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
            element.click();
            Alert alert = webDriver.switchTo().alert();
            String alertMessage = webDriver.switchTo().alert().getText();
            System.out.println(alertMessage);
            Thread.sleep(1000);
            alert.accept();
            Thread.sleep(1000);
            element.click();
            Thread.sleep(1000);
            alert.dismiss();
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void inputOnAlert() {
        try {
            webDriver.get("http://the-internet.herokuapp.com/javascript_alerts");
            WebElement element = webDriver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
            element.click();
            Alert alert = webDriver.switchTo().alert();
            Thread.sleep(1000);
            alert.sendKeys("hello");
            Thread.sleep(10000);
            alert.accept();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void uploadPopUp() {
        try {
            webDriver.get("http://the-internet.herokuapp.com/upload");
            WebElement element = webDriver.findElement(By.xpath("//input[@id='file-upload']"));
            element.sendKeys("C:/Users/Shivani/Downloads/download.png");
            Thread.sleep(10000);
            webDriver.findElement(By.xpath("//input[@id='file-submit']")).click();
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

