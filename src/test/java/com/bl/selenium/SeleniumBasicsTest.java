package com.bl.selenium;

import com.bl.selenium.Action.Action;
import com.bl.selenium.base.Base;
import com.bl.selenium.robot.RobotBasic;
import com.bl.selenium.select.SelectClass;
import com.bl.selenium.windowhandling.AlertAndPopup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class SeleniumBasicsTest extends Base {
    Action action;
    RobotBasic robot;
    AlertAndPopup handling;
    SelectClass select;

    @BeforeMethod
    public void setup() throws AWTException {
        initializeBase();
        robot = new RobotBasic();
        action = new Action();
        select = new SelectClass();
        handling = new AlertAndPopup();
    }

    @Test
    public void actionClassTest() throws InterruptedException {
        action.dragDrop();
        action.rightClick();
        action.mouseOver();
        action.doubleClick();
        action.mouseClick();
        action.scroll();
    }

    @Test
    public void robotTest() throws AWTException, InterruptedException {
        robot.robotOperations();
        robot.copyToNotePad();
    }


    @Test
    public void alertHandling() {
        handling.clickAlert();
        handling.clickOkAndCancelAlert();
        handling.inputOnAlert();
        handling.uploadPopUp();
    }

    @Test
    public void popUpHandling() {
        handling.uploadPopUp();
    }

    @Test
    public void dropDownTest() {
        select.dropDown();
        select.selectDateByClick();
        select.selectByOptions();
        select.multiSelect("Florida", "New York", "Texas");
    }
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}

