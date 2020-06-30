package com.bl.selenium;

import com.bl.selenium.Action.Action;
import com.bl.selenium.base.Base;
import com.bl.selenium.iframe.Frames;
import com.bl.selenium.otp.OTP;
import com.bl.selenium.robot.RobotBasic;
import com.bl.selenium.select.SelectClass;
import com.bl.selenium.windowhandling.AlertAndPopup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class SeleniumBasicsTest extends Base {
    static Logger logger = LogManager.getLogger(SeleniumBasicsTest.class);

    Action action;
    RobotBasic robot;
    AlertAndPopup handling;
    SelectClass select;
    Frames frame;
    OTP otp;

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
    }

   @Test
    public void actionClassTest() throws InterruptedException {
        logger.info("All Action class Test");
        action.dragDrop();
        action.rightClick();
        action.mouseHover();
        action.doubleClick();
        action.mouseClick();
        action.scroll();
    }

    @Test
    public void robotTest() throws AWTException, InterruptedException {
        logger.info("All Action class Test");
        robot.robotOperations();
        robot.copyToNotePad();
    }

    @Test
    public void alertHandling() {
        logger.info("All Alert Handling Test");
        handling.clickAlert();
        handling.clickOkAndCancelAlert();
        handling.inputOnAlert();
    }

    @Test
    public void popUpHandling() throws InterruptedException {
        logger.info("All frames Handling Test");
        handling.uploadPopUp();
        handling.popUp();
    }

   @Test
    public void dropDownTest() {
        logger.info("All drop down test");
        select.dropDown();
        select.selectDateByClick();
        select.selectByOptions();
        select.multiSelect("Florida", "New York", "Texas");
    }

    @Test
    public void framesTest() {
        logger.info("All frame handling test");
        frame.frame();
    }

    @Test
    public void registerUsingOTP() {
        logger.info("amazon registration");
        otp.amazonRegistration("siddhesh", "abcd@12345");
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser Closed");
    }
}
