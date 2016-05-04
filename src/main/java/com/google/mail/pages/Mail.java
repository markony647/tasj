package com.google.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.google.mail.core.ConciseAPI.*;
import static com.google.mail.core.CustomConditions.*;


public class Mail {
    public static String mails = "[gh='tl'] .zA";


    public static void send(String recipient, String subjectText) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(recipient + Keys.ENTER);
        $(By.name("subjectbox")).sendKeys(subjectText + Keys.ENTER);
        $(byText("Send")).click();
    }

    public static void searchBySubject(String subjectText) {
        $(By.name("q")).sendKeys("subject: " + subjectText + Keys.ENTER);
    }

    public static void assertMails(String... mailsTexts) {
        assertThat(textsOf(byCss(mails), mailsTexts));
    }

    public static void assertMail(int index, String subjectText) {
        assertThat(listNthElementHasText(byCss(mails), index, subjectText));
    }

}