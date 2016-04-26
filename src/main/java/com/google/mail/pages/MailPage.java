package com.google.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.google.mail.core.CustomConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class MailPage extends BasePage {

    public static String mails = "[gh='tl'] .zA";

    public MailPage(WebDriver driver, long timeout) {
        super(driver, timeout);
    }

    public void send(String recipient, String subjectText) {
        wait.until(visibilityOfElementLocated(By.xpath("//*[contains(text(),'COMPOSE')]"))).click();  // By.cssSelector ("[gh='cm']") -выбрал xpath потому как-то более наглядно

        wait.until(visibilityOfElementLocated(By.name("to"))).sendKeys(recipient + Keys.ENTER);

        wait.until(visibilityOfElementLocated(By.name("subjectbox"))).sendKeys(subjectText + Keys.ENTER);

        wait.until(visibilityOfElementLocated(By.cssSelector("[aria-label^='Send']"))).click();
    }

    public void searchBySubject(String subjectText) {
        driver.findElement(By.name("q")).sendKeys("subject: " + subjectText + Keys.ENTER);
    }

    public void assertMails(String... mailsTexts) {
        wait.until(textsToBePresentInElementLocated(By.cssSelector(mails), mailsTexts));
    }

    public void assertMail(int index, String subjectText) {
        wait.until(textToBe(By.cssSelector(mails + ":nth-of-type(" + (index + 1) + ") .y6"), subjectText));
    }
}