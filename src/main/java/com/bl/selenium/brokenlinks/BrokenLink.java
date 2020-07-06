package com.bl.selenium.brokenlinks;

import com.bl.selenium.base.Base;
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

public class BrokenLink extends Base {

    @Test
    public void brokenLinks() throws IOException {
        try {

            initializeBase();
            webDriver.get("http://www.newtours.demoaut.com/");
            Thread.sleep(5000);
            List<WebElement> list = webDriver.findElements(By.tagName("a"));
            list.addAll(webDriver.findElements(By.tagName("img")));
            System.out.println("All the links:" + list.size());
            List<WebElement> activeList = new ArrayList<>();
            for(WebElement webElement : list) {
                if(webElement.getAttribute("href") != null) {
                    activeList.add(webElement);
                }
            }
            System.out.println("Active links on page" + activeList.size());
            for(WebElement element : activeList) {
                HttpURLConnection connection = (HttpURLConnection) new URL(element.getAttribute("href")).openConnection();
                connection.connect();
                String responseMessage = connection.getResponseMessage();
                int responseCode = connection.getResponseCode();
                System.out.println(element.getAttribute("href") + "---->" + responseMessage + responseCode);
            }
        } catch(InterruptedException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}