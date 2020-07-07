package com.bl.selenium;

import com.bl.selenium.Action.Action;
import com.bl.selenium.base.SeleniumBasicBase;
import com.bl.selenium.brokenlinks.BrokenLink;
import com.bl.selenium.exception.Exceptions;
import com.bl.selenium.iframe.Frames;
import com.bl.selenium.otp.OTP;
import com.bl.selenium.robot.RobotBasic;

import com.bl.selenium.tooltip.ToolTip;
import com.bl.selenium.windowhandling.AlertAndPopup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.bl.selenium.select.SelectClass;

import java.awt.*;
import java.io.IOException;

public class SeleniumBasicsTest extends SeleniumBasicBase {
    static Logger logger = LogManager.getLogger(SeleniumBasicsTest.class);// logging the test

    Action action;
    RobotBasic robot;
    AlertAndPopup handling;
    SelectClass select;
    Frames frame;
    OTP otp;
    Exceptions exceptions;
    BrokenLink link;
    ToolTip tip;

    @BeforeMethod
    public void setup() throws AWTException {
        logger.info("Setting Up Method for all test");
        initializeBase();
        robot = new RobotBasic();
        action = new Action();
        select = new SelectClass();
        handling = new AlertAndPopup();
        frame = new Frames();
        otp = new OTP();
        exceptions = new Exceptions();
        link=new BrokenLink();
        tip=new ToolTip();
    }

    //Test for Action class
    @Test(priority = 1)
    public void actionClassTest() throws InterruptedException {
        logger.info("All Action class Test");
        action.dragDrop();
        Thread.sleep(5000);
        action.rightClick();
        Thread.sleep(5000);
        action.mouseHover();
        Thread.sleep(5000);
        action.doubleClick();
        Thread.sleep(5000);
        action.mouseClick();
        Thread.sleep(5000);
        action.scroll();
    }

    //Test for robot class
    @Test(priority = 2)
    public void robotTest() throws AWTException, InterruptedException {
        logger.info("All Action class Test");
        robot.robotOperations();
        robot.copyToNotePad();
    }

    //Test for alert handling
    @Test(priority = 3)
    public void alertHandling() {
        logger.info("All Alert Handling Test");
        handling.clickAlert();
        handling.clickOkAndCancelAlert();
        handling.inputOnAlert();
    }

    //Test for popup handling
    @Test(priority = 4)
    public void popUpHandling() throws InterruptedException {
        logger.info("All frames Handling Test");
        handling.uploadPopUp();
        handling.popUp();
    }

    //Test for Dropdown list
    @Test(priority = 5)
    public void dropDownTest() {
        logger.info("All drop down test");
        select.dropDown();
        select.selectDateByClick();
        select.selectByOptions();
        select.multiSelect("Florida", "New York", "Texas");
    }

    //Test for frame handling
    @Test(priority = 6)
    public void framesTest() {
        logger.info("All frame handling test");
        frame.frame();
    }

    //Test for OTP Handling
    @Test(priority = 7)
    public void registerUsingOTP() {
        logger.info("amazon registration");
        otp.amazonRegistration("siddhesh", "abcd@12345");
    }

    //Test for exception Handling
    @Test(priority = 8)
    public void handleExceptions() throws InterruptedException {
        exceptions.elementNotVisible();
        exceptions.timeOutTest();
        exceptions.noSuchElement();
        exceptions.staleElement();
    }

    //Test for broken Links
    @Test
    public void brokenLinkTest() throws IOException {
        link.brokenLinks();
    }

    //Test for ToolTip
    @Test
    public void toolTipTest() {
        tip.toolTip();
    }

    //Close browser after test
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser Closed");
    }
}
