package com.google.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class GmailPage extends BasePage {

    public GmailPage(WebDriver driver, long timeout) {
        super(driver, timeout);
    }

    public void visit() {
        open("https://gmail.com");
    }

    public void login(String email, String password) {

        wait.until(visibilityOfElementLocated(By.cssSelector("#Email"))).sendKeys(email + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector("#Passwd"))).sendKeys(password + Keys.ENTER);
    }

}
