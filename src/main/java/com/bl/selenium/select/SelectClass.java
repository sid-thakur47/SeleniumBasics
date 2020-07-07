package com.bl.selenium.select;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.lang.reflect.Array;
import java.util.List;

public class SelectClass extends SeleniumBasicBase {
    String day = "//select[@id='day']//option";
    String month = "//select[@name='birthday_month']//option";
    String year = "//select[@id='year']//option";

    //method to select multiple values from dropdown
    public  void selectFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    //select date by element
    public static void getDate(String xpathValue, String value) {
        List<WebElement> element = webDriver.findElements(By.xpath(xpathValue));//find all elements
        //if element text equals value select the date
        for(int i = 0; i <= element.size(); i++) {
            System.out.println("values" + element.get(i).getText().equals(value));
            if(element.get(i).getText().equals(value)) {
                element.get(i).click();//click on date
                break;
            }
        }
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

    //select date while registration of facebook
    public void dropDown() {
        webDriver.get("http://facebook.com");
        WebElement day = webDriver.findElement(By.xpath("//select[@id='day']"));//get day element
        WebElement month = webDriver.findElement(By.xpath("//select[@name='birthday_month']"));//get month element
        WebElement year = webDriver.findElement(By.xpath("//select[@id='year']"));//get year element
        String dob = "9-May-1995";
        String[] bDate = dob.split("-");//split by -
        selectFromDropDown(day, bDate[0]);//put day at position 0
        selectFromDropDown(month, bDate[1]);//put month at position 1
        selectFromDropDown(year, bDate[2]);//put year at position 2
    }

    public void selectByOptions() {
        try {
            webDriver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
            WebElement webElement = webDriver.findElement(By.xpath("//select[@class='form-control']"));
            webElement.click();
            Thread.sleep(1000);
            Select select = new Select(webElement);
            select.selectByIndex(1);//select using index
            Thread.sleep(5000);
            select.selectByValue("Tuesday");//select using value
            Thread.sleep(5000);
            select.selectByVisibleText("Saturday");//select by visible text
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    //to select multiple value from dropdown
    public void multiSelect(String... values) {
        try {
            webDriver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
            WebElement webElement = webDriver.findElement(By.xpath("//select[@name='States']"));
            Select select = new Select(webElement);
            boolean multiple = select.isMultiple();
            if(multiple) {
                for(int i = 0; i <= values.length-1; i++) {
                    String s = (String) Array.get(values, i);
                    select.selectByValue(s);//select option using value
                }
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}