package com.bl.selenium.datepicker;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


public class DatePickerTest extends SeleniumBasicBase {
    @Test
    public void testDaTePicker() throws InterruptedException {
        initializeBase();
        webDriver.get("http://demo.automationtesting.in/Datepicker.html");
        JavascriptExecutor je = webDriver;
        je.executeScript("document.getElementById('datepicker1').value= '09/9/1995'");
        Thread.sleep(3000);
        webDriver.quit();
    }
}