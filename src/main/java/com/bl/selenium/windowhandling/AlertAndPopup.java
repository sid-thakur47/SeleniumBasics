package com.bl.selenium.windowhandling;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class AlertAndPopup extends SeleniumBasicBase {

    public void clickAlert() {
        try {
            webDriver.get("http://the-internet.herokuapp.com/javascript_alerts");
            WebElement element = webDriver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
            element.click();
            Thread.sleep(1000);
            Alert alert = webDriver.switchTo().alert();//switch to alert
            Thread.sleep(1000);
            String alertMessage = webDriver.switchTo().alert().getText();
            System.out.println(alertMessage);//print alert message
            alert.accept();//accept the alert
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
            Alert alert = webDriver.switchTo().alert();//switch to alert
            String alertMessage = webDriver.switchTo().alert().getText();
            System.out.println(alertMessage);//print alert message
            Thread.sleep(1000);
            alert.accept();//accept the alert
            Thread.sleep(1000);
            element.click();
            Thread.sleep(1000);
            alert.dismiss();//dismiss the alert
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
            Alert alert = webDriver.switchTo().alert();//switch to alert
            Thread.sleep(1000);
            alert.sendKeys("hello");//send input to alert
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
            element.sendKeys("C:/Users/Shivani/Downloads/download.png");//send image path
            Thread.sleep(10000);
            webDriver.findElement(By.xpath("//input[@id='file-submit']")).click();//click on upload
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void popUp() throws InterruptedException {
        webDriver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
        WebElement element = webDriver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]"));
        element.click();
        Thread.sleep(1000);
        Set<String> handles = webDriver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();//iterate over handles
        String subWindow = null;
        while(iterator.hasNext()) {
            subWindow = iterator.next();//iterate till child window
        }
        webDriver.switchTo().window(subWindow);//switch to opo up window
        WebElement element1 = webDriver.findElement(By.xpath("//span[contains(text(),'No, thanks')]"));
        element1.click();
        Thread.sleep(5000);
        webDriver.close();
    }
    @Test
    public void booksWagonTest() {
        try {
            initializeBase();
            webDriver.get("https://www.bookswagon.com/login");
            WebElement userName = webDriver.findElement(By.xpath("//input[@id='ctl00_phBody_SignIn_txtEmail']"));
            userName.sendKeys(properties.getProperty("email"));//input email id
            WebElement password = webDriver.findElement(By.xpath("//input[@id='ctl00_phBody_SignIn_txtPassword']"));
            password.sendKeys(properties.getProperty("bpass"));//input password
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//input[@name='ctl00$phBody$SignIn$btnLogin']")).click();
            Thread.sleep(5000);
            WebElement cart = webDriver.findElement(By.xpath("//a[@class='cart-pop iframe cart-link sprite cart-linkbg cboxElement']"));
            cart.click();
            Thread.sleep(5000);
            WebElement element = webDriver.findElement(By.xpath("//iframe[@name='cbox1594058220570']"));
            WebDriverWait wb=new WebDriverWait(webDriver,10);
            wb.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//iframe[@name='cbox1594058220570']")));
            webDriver.switchTo().frame(element);//switch to frame
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//a[@id='BookCart_lvCart_ctrl0_imgDelete']")).click();
            Thread.sleep(5000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

