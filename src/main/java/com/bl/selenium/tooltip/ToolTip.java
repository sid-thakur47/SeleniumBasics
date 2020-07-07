package com.bl.selenium.tooltip;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class ToolTip extends SeleniumBasicBase {

    public void toolTip() {
        try {
            initializeBase();
            Actions actions = new Actions(webDriver);
            webDriver.get("http://seleniumpractise.blogspot.com/2019/08/tooltip-in-selenium-or-help-text-example.html");
            WebElement element = webDriver.findElement(By.xpath("//div[@class='tooltip']")); //span[class='tooltiptext']
            actions.moveToElement(element).build().perform();
            Thread.sleep(5000);
            String text = webDriver.findElement(By.xpath("//span[@class='tooltiptext']")).getText();
            Assert.assertEquals("Tool tip text",text);

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
