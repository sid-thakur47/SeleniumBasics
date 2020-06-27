package com.bl.selenium;

import com.bl.selenium.Action.Action;
import com.bl.selenium.base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTest extends Base {
    Action action;

    @BeforeMethod
    public void setup() {
        initializeBase();
        action = new Action();
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

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}

