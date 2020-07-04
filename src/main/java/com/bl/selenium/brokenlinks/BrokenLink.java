package com.bl.selenium.brokenlinks;

import com.bl.selenium.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLink extends Base {
    static Logger logger = LogManager.getLogger(BrokenLink.class);
    public void brokenLinks() throws IOException {
        try {
            initializeBase();
            webDriver.get("http://www.zlti.com");
            logger.info("Url is open");
            Thread.sleep(5000);
            List<WebElement> list = webDriver.findElements(By.tagName("a"));
            list.addAll(webDriver.findElements(By.tagName("img")));
            int allLinks = list.size();
            logger.info("All links", allLinks);
            System.out.println("All the links:" + allLinks);
            List<WebElement> activeList = new ArrayList<>();
            for(int i = 0; i <= list.size() - 1; i++) {
                if(list.get(i).getAttribute("href") != null) {
                    activeList.add(list.get(i));
                    System.out.println("Active Link List" + activeList.get(i).getAttribute("href"));
                }
            }
            int activeLinks = activeList.size();
            System.out.println("Active links on page" + activeLinks);
            int brokenLinks = allLinks - activeLinks;
            System.out.println("Number of broken links=" + brokenLinks);
            for(int i=0;i<=activeList.size();i++){
                HttpURLConnection connection= (HttpURLConnection) new URL(activeList.get(i).getAttribute("href")).openConnection();
                connection.connect();
                String responseMessage = connection.getResponseMessage();
                System.out.println(activeList.get(i).getAttribute("href")+"---->"+responseMessage);
            }
        } catch(InterruptedException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}