package com.bl.selenium.otp;

import com.bl.selenium.base.Base;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class OTP extends Base {

    private static final String ACCOUNT_SID = properties.getProperty("id");
    private String TOKEN = properties.getProperty("token");

    public static String getMessage() {
        return getMessages()
                .filter(m -> m.getTo().equals("+12029329389")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages() {
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }

    public void amazonRegistration(String username, String pass) {
        try {
            webDriver.get(properties.getProperty("amazonUrl"));
            WebElement name = webDriver.findElement(By.xpath("//input[@id='ap_customer_name']"));
            name.sendKeys(username);
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//a[@id='auth-country-picker_212']")).click();
            WebElement phoneNumber = webDriver.findElement(By.xpath("//input[@id='ap_phone_number']"));
            phoneNumber.sendKeys("12029329389");
            Thread.sleep(5000);
            WebElement password = webDriver.findElement(By.xpath("//input[@id='ap_password']"));
            password.sendKeys(pass);
            Thread.sleep(5000);
            WebElement clickContinue = webDriver.findElement(By.xpath("//input[@id='continue']"));
            clickContinue.click();
            Thread.sleep(5000);
            Twilio.init(ACCOUNT_SID, TOKEN);
            String message = getMessage();
            String OTPNumber = message.replaceAll("[^-?0-9]+", " ");
            webDriver.findElement(By.xpath("//input[@id='auth-pv-enter-code']")).sendKeys(OTPNumber);
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
