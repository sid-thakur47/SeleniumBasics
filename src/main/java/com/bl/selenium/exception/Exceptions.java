package com.bl.selenium.exception;

import com.bl.selenium.base.SeleniumBasicBase;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class Exceptions extends SeleniumBasicBase {

    //initialize URL and start Button
    public void initialize() {
        webDriver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = webDriver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();
    }

    public void elementNotVisible() {
        initialize();
        WebElement finishElement = webDriver.findElement(By.id("finish"));
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(finishElement));//wait until visibility of finish element
        String finishText = finishElement.getText();//after visibility of element get text of the element
        Assert.assertEquals(finishText, "Hello World!");//verify the text
    }

    public void timeOutTest() throws InterruptedException {
        initialize();
        WebElement finishElement = webDriver.findElement(By.id("finish"));
        WebDriverWait wait = new WebDriverWait(webDriver, 2);//wait for 2 sec
        try {
            wait.until(ExpectedConditions.visibilityOf(finishElement));//wait until visibility of finish element
        } catch(TimeoutException exception) {
            System.out.println("Exception: " + exception.getMessage());//if element is not visible  catch exception and print it
            sleep(3000);
        }
        String finishText = finishElement.getText(); //element is visible the get its text
        Assert.assertTrue(finishText.contains("Hello World!"));//verify the text
    }

    public void noSuchElement() {
        webDriver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement startButton = webDriver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        //wait unit element text is located at location and verify the text
        Assert.assertTrue(
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("finish"), "Hello World!")),
                "Couldn't verify 'Hello World!'");
    }

    public void staleElement() {
        webDriver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox = webDriver.findElement(By.id("checkbox"));
        WebElement removeButton = webDriver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(checkBox)),//wait until element disappears
                "Checkbox is still visible, but shouldn't be");
        WebElement addButton = webDriver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        addButton.click();//click on add button
        //wait unit visibility of element
        WebElement checkbox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        //verify the element
        Assert.assertTrue(checkbox2.isDisplayed(), "Checkbox is not visible, but it should be");
    }
}
