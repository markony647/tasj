package com.google.mail.pages;

import com.google.mail.core.base.LazyCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static com.google.mail.core.ConciseAPI.*;
import static com.google.mail.core.conditions.CollectionConditions.texts;


public class Mail {

    public static LazyCollection mails =  $$("[gh='tl'] .zA");


    public static void send(String recipient, String subjectText) {

        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(recipient + Keys.ENTER);
        $(By.name("subjectbox")).setValue(subjectText + Keys.ENTER);
        $(byText("Send")).click();
    }

    public static void searchBySubject(String subjectText) {
        $(By.name("q")).setValue("subject: " + subjectText + Keys.ENTER);
    }

    public static void assertMails(String... mailsTexts) {
        mails.shouldHave(texts(mailsTexts));
    }

    public static void assertMail(int index, String subjectText) {
        //assertThat(byCss(mails), nthElementHasText(index, subjectText));
    }

}