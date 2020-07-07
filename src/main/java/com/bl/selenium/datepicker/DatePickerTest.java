package com.bl.selenium.datepicker;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


public class DatePickerTest extends SeleniumBasicBase {
    @Test
    public void testDaTePicker() throws InterruptedException {
        initializeBase();//initialize chrome browser
        webDriver.get("http://demo.automationtesting.in/Datepicker.html");//get URL
        JavascriptExecutor je = webDriver;//type cast to java script object
        je.executeScript("document.getElementById('datepicker1').value= '09/9/1995'");//javascript to pick a Date
        Thread.sleep(3000);
        webDriver.quit();//close browser
    }
}