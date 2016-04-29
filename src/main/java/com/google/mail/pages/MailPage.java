package com.google.mail.pages;

import com.google.mail.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.google.mail.core.CustomConditions.*;


public class MailPage extends BasePage {

    public static String mails = "[gh='tl'] .zA";

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void send(String recipient, String subjectText) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(recipient + Keys.ENTER);
        $(By.name("subjectbox")).sendKeys(subjectText + Keys.ENTER);
        $(byText("Send")).click();
    }

    public void searchBySubject(String subjectText) {
        $(By.name("q")).sendKeys("subject: " + subjectText + Keys.ENTER);
    }

    public void assertMails(String... mailsTexts) {
        assertThat(textsOf(byCss(mails), mailsTexts));
    }

    public void assertMail(int index, String subjectText) {
        assertThat(listNthElementHasText(byCss(mails), index, subjectText));
    }
}