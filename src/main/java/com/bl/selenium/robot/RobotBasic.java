package com.bl.selenium.robot;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RobotBasic extends SeleniumBasicBase {
    Robot robot = new Robot();
    public RobotBasic() throws AWTException {
    }

    public void robotOperations() throws  InterruptedException {
        webDriver.get("https://www.youtube.com/");
        //to scroll ata end
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_END);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_END);
        Thread.sleep(1000);
        WebElement search = webDriver.findElement(By.xpath("//input[@id='search']"));
        search.click();
        Thread.sleep(5000);
        //search on youtube
        search.sendKeys("Robot Check");
        Thread.sleep(10000);
        //press enter
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
    }

    public void copyToNotePad() {
        try {
            webDriver.get("http://the-internet.herokuapp.com/floating_menu");
            //Select all content from page
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_A);
            Thread.sleep(5000);
            //copy all content from page
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_C);
            Thread.sleep(5000);
            //open notepad
            Runtime.getRuntime().exec("C:/Windows/notepad.exe");
            Thread.sleep(10000);
            //paste copied text on notepad
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_S);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
        } catch(InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
