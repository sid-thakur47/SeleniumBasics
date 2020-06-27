package com.bl.selenium;

import com.bl.selenium.Action.Action;
import com.bl.selenium.base.Base;
import com.bl.selenium.robot.RobotBasic;
import com.bl.selenium.windowhandling.AlertAndPopup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class SeleniumBasicsTest extends Base {
    Action action;
    RobotBasic robot;
    AlertAndPopup handling;

    @BeforeMethod
    public void setup() throws AWTException {
        initializeBase();
        robot = new RobotBasic();
        action = new Action();
        handling = new AlertAndPopup();
    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        action.dragDrop();
    }

    @Test
    public void testContextSwitch() {
        action.rightClick();
    }

    @Test
    public void mouseHover() throws InterruptedException {
        action.mouseOver();
    }

    @Test
    public void doubleClick() throws InterruptedException {
        action.doubleClick();
    }

    @Test
    public void mouseClick() throws InterruptedException {
        action.mouseClick();
    }

    @Test
    public void scrollClick() throws InterruptedException {
        action.scroll();
    }

    @Test
    public void robotTest() throws AWTException, InterruptedException {
        robot.robotOperations();
    }

    @Test
    public void copyText() {
        robot.copyToNotePad();
    }

    @Test
    public void alertHandling() {
        handling.clickAlert();
        handling.clickOkAndCancelAlert();
        handling.inputOnAlert();
        //handling.uploadPopUp();
    }

    @Test
    public void popUpHandling() {
        handling.uploadPopUp();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}

