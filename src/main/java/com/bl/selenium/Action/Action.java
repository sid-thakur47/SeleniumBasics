package com.bl.selenium.Action;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action extends SeleniumBasicBase {
    Actions actions = new Actions(webDriver);

    public  void mouseClick() throws InterruptedException {
        webDriver.get("https://www.google.com");//get url
        Thread.sleep(1000);
        WebElement imLucky = webDriver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='RNmpXc']"));
        Actions action = new Actions(webDriver);
        Thread.sleep(1000);
        action.moveToElement(imLucky).perform();//move element at particular element
        Thread.sleep(1000);
        imLucky.click();//click on element
        Thread.sleep(1000);
    }

    public void dragDrop() throws InterruptedException {

        webDriver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html"); //get url
        WebElement element1 = webDriver.findElement(By.xpath("//h1[.='Block 1']"));//find elements
        WebElement element2 = webDriver.findElement(By.xpath("//h1[.='Block 2']"));
        Thread.sleep(1000);
        actions.dragAndDrop(element1, element2).build().perform();//drag element 1 to element 2
        Thread.sleep(1000);
        actions.dragAndDrop(element2, element1).build().perform();//drag element 2 to element 1
    }

    public void rightClick() {
        webDriver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");//get url
        WebElement context = webDriver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        actions.contextClick(context).perform();//right click on element
    }

    public void mouseHover()  {
        try {
            webDriver.get("https://www.canva.com/");//get url
            WebElement hover = webDriver.findElement(By.xpath("//body/div[@id='root']/div[@class='yIDCqA']/main[@class='mXPP6A']/div[@class='Q7frNQ']/div[@class='_2pukyg']/div[@class='IMy50w a6f7yQ']/header[@class='_-VxbfQ']/div[@class='B74wyQ']/nav/ul[@class='_8C4r8g n9zSJA ZTpOuQ qKkDjQ']/li[4]/div[1]/div[1]/a[1]"));
            WebElement hover2 = webDriver.findElement(By.xpath("//body/div[@id='root']/div/main/div[4]/div[1]"));
            actions.moveToElement(hover).build().perform();//hover the element
            Thread.sleep(4000);
            actions.moveToElement(hover2).build().perform();
            Thread.sleep(4000);
            actions.moveToElement(hover).build().perform();
            Thread.sleep(4000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doubleClick() {
        webDriver.get("https://www.browserstack.com/");
        WebElement doubleClick = webDriver.findElement(By.xpath("//a[@id='free-trial-link-anchor']"));
        actions.doubleClick(doubleClick).build().perform();//double click on element
    }

    public void scroll() throws InterruptedException {
        webDriver.get("https://testproject.io/?utm_medium=forum&utm_campaign=Ripon-Wasim-all&utm_source=forums");
        Thread.sleep(1000);
        JavascriptExecutor je = webDriver;
            je.executeScript("window.scrollBy(0,1000)");//java script to scroll
            Thread.sleep(1000);
            //scrolling using send keys
            webDriver.findElement(By.xpath("//li[@id='menu-item-418']//a[contains(text(),'Platform')]")).sendKeys(Keys.CONTROL,Keys.END);
            Thread.sleep(1000);
    }
}
