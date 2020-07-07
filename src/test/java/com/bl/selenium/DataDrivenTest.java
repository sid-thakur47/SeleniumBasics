package com.bl.selenium;

import com.bl.selenium.base.SeleniumBasicBase;
import com.bl.selenium.poi.DataDriven;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest extends SeleniumBasicBase {

    @Test(dataProvider = "Facebook login")
    public static void facebookLogin(String username, String password) throws InterruptedException {
        initializeBase();
        webDriver.get("https://www.facebook.com");
        webDriver.findElement(By.id("email")).sendKeys(username);//input username
        webDriver.findElement(By.name("pass")).sendKeys(password);//input password
        webDriver.findElement(By.id("loginbutton")).click();//click on login
        Thread.sleep(5000);
    }

    //data provider for test
    @DataProvider(name = "Facebook login")
    public Object[][] loginData() {
        DataDriven data = new DataDriven();
        data.initializeSheet("C:/Users/Shivani/Desktop/Backup/TestData.xlsx");
        int totalRows = data.getTotalRows(0);//get total rows
        String[][] credentials = new String[totalRows][2];
        //get data from excel sheet
        for(int i = 0; i < totalRows; i++) {
            credentials[i][0] = data.getData(0, i, 0);
            credentials[i][1] = data.getData(0, i, 1);
        }
        return credentials;
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
