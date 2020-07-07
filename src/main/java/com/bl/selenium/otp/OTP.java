package com.bl.selenium.otp;

import com.bl.selenium.base.SeleniumBasicBase;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class OTP extends SeleniumBasicBase {

    private static final String ACCOUNT_SID = properties.getProperty("id");//Account id
    private String TOKEN = properties.getProperty("token");//Auth Token

    //to filter message and get first message
    public static String getMessage() {
        return getMessages()
                .filter(m -> m.getTo().equals("+12029329389")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    //get all message for the account
    private static Stream<Message> getMessages() {
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }

    //register to amazon shopping site
    public void amazonRegistration(String username, String pass) {
        try {
            webDriver.get(properties.getProperty("amazonUrl"));
            WebElement name = webDriver.findElement(By.xpath("//input[@id='ap_customer_name']"));
            name.sendKeys(username);//send user name
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//a[@id='auth-country-picker_212']")).click();
            WebElement phoneNumber = webDriver.findElement(By.xpath("//input[@id='ap_phone_number']"));
            phoneNumber.sendKeys("12029329389");//add phone number
            Thread.sleep(5000);
            WebElement password = webDriver.findElement(By.xpath("//input[@id='ap_password']"));
            password.sendKeys(pass);//send password
            Thread.sleep(5000);
            WebElement clickContinue = webDriver.findElement(By.xpath("//input[@id='continue']"));
            clickContinue.click();
            Thread.sleep(5000);
            Twilio.init(ACCOUNT_SID, TOKEN);//initialize token and account id
            String message = getMessage();//get message for account
            String OTPNumber = message.replaceAll("[^-?0-9]+", " ");//filter only to get OTP number
            webDriver.findElement(By.xpath("//input[@id='auth-pv-enter-code']")).sendKeys(OTPNumber);//send OTP
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
