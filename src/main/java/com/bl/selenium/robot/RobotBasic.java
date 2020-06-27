package com.bl.selenium.robot;

import com.bl.selenium.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RobotBasic extends Base {
    Robot robot = new Robot();

    public RobotBasic() throws AWTException {
    }

    public void robotOperations() throws AWTException, InterruptedException {
        webDriver.get("https://www.youtube.com/");
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
        search.sendKeys("Robot Check");
        Thread.sleep(10000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
    }

    public void copyToNotePad() {
        try {
            webDriver.get("http://the-internet.herokuapp.com/floating_menu");
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_A);
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_C);
            Thread.sleep(5000);
            Runtime.getRuntime().exec("C:/Windows/notepad.exe");
            Thread.sleep(10000);
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
