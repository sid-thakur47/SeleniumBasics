package com.bl.selenium;

import com.bl.selenium.Action.Action;
import com.bl.selenium.base.Base;
import com.bl.selenium.iframe.Frames;
import com.bl.selenium.otp.OTP;
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
    Frames frame;
    OTP otp;

    @BeforeMethod
    public void setup() throws AWTException {
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
        action.dragDrop();
        action.rightClick();
        action.mouseHover();
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
    }

    @Test
    public void popUpHandling() throws InterruptedException {
        handling.uploadPopUp();
        handling.popUp();
    }

    @Test
    public void dropDownTest() {
        select.dropDown();
        select.selectDateByClick();
        select.selectByOptions();
        select.multiSelect("Florida", "New York", "Texas");
    }

    @Test
    public void framesTest() {
        frame.frame();
    }

    @Test
    public void registerUsingOTP() {
        otp.amazonRegistration("siddhesh", "abcd@12345");
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
