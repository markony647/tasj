package com.google.mail.pages;

import com.google.mail.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class GmailPage extends BasePage {

    public GmailPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        open("https://gmail.com");
    }

    public void login(String email, String password) {

        $("#Email").sendKeys(email + Keys.ENTER);
        $("#Passwd").sendKeys(password + Keys.ENTER);

    }


}
