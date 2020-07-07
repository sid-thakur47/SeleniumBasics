package com.bl.selenium.brokenlinks;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLink extends SeleniumBasicBase {

    @Test
    public void brokenLinks() throws IOException {
        try {
            initializeBase();//browser initialization
            webDriver.get("http://www.newtours.demoaut.com/");//open  URL
            Thread.sleep(5000);
            List<WebElement> list = webDriver.findElements(By.tagName("a"));//get all elements with a tag
            list.addAll(webDriver.findElements(By.tagName("img")));//add elements with img tag to list
            System.out.println("All the links:" + list.size());
            List<WebElement> activeList = new ArrayList<>();
            for(WebElement webElement : list) { //filter only elements having href
                if(webElement.getAttribute("href") != null) {
                    activeList.add(webElement);
                }
            }
            System.out.println("Active links on page" + activeList.size());
            //get link from the list and check for broken and safe link
            for(WebElement element : activeList) {
                HttpURLConnection connection = (HttpURLConnection) new URL(element.getAttribute("href")).openConnection();
                connection.connect();//connect to current link
                String responseMessage = connection.getResponseMessage();//get response message of link
                int responseCode = connection.getResponseCode();//get response code of the link
                System.out.println(element.getAttribute("href") + "---->" + responseMessage + responseCode);
            }
        } catch(InterruptedException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //close browser
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}