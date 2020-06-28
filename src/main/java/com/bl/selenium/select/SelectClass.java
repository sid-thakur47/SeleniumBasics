package com.bl.selenium.select;

import com.bl.selenium.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.List;

public class SelectClass extends Base {
    String day = "//select[@id='day']//option";
    String month = "//select[@name='birthday_month']//option";
    String year = "//select[@id='year']//option";

    public static void selectFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public static void getDate(String xpathValue, String value) {
        List<WebElement> element = webDriver.findElements(By.xpath(xpathValue));
        for(int i = 0; i <= element.size(); i++) {
            System.out.println("values" + element.get(i).getText().equals(value));
            if(element.get(i).getText().equals(value)) {
                element.get(i).click();
                break;
            }
        }
    }

    public void dropDown() {
        webDriver.get("http://facebook.com");
        WebElement day = webDriver.findElement(By.xpath("//select[@id='day']"));
        WebElement month = webDriver.findElement(By.xpath("//select[@name='birthday_month']"));
        WebElement year = webDriver.findElement(By.xpath("//select[@id='year']"));
        String dob = "9-May-1995";
        String[] bDate = dob.split("-");
        selectFromDropDown(day, bDate[0]);
        selectFromDropDown(month, bDate[1]);
        selectFromDropDown(year, bDate[2]);
    }

    public void selectDateByClick() {
        try {
            webDriver.get("http://facebook.com");
            getDate(day, "9");
            getDate(month, "Sept");
            getDate(year, "1998");
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void selectByOptions() {
        try {
            webDriver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
            WebElement webElement = webDriver.findElement(By.xpath("//select[@class='form-control']"));
            webElement.click();
            Thread.sleep(1000);
            Select select = new Select(webElement);
            select.selectByIndex(1);
            Thread.sleep(5000);
            select.selectByValue("Tuesday");
            Thread.sleep(5000);
            select.selectByVisibleText("Saturday");
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void multiSelect(String... values) {
        try {
            webDriver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
            WebElement webElement = webDriver.findElement(By.xpath("//select[@name='States']"));
            Select select = new Select(webElement);
            boolean multiple = select.isMultiple();
            System.out.println("Elements" + webElement);
            if(multiple) {
                for(int i = 0; i <= values.length - 1; i++) {
                    select.selectByValue((String) Array.get(values, i));
                }
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}