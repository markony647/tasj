package com.google.mail;

import com.google.mail.testdata.TestData;
import org.junit.Test;
import com.google.mail.pages.GmailPage;
import com.google.mail.pages.MailPage;
import com.google.mail.pages.MenuPage;

import java.util.Date;

import static com.google.mail.testconfigs.TestConfigs.timeOutInSeconds;


public class GmailTest extends BaseTest {

    GmailPage gmailPage = new GmailPage(driver, timeOutInSeconds);
    MailPage mailPage = new MailPage(driver, timeOutInSeconds);
    MenuPage menuPage = new MenuPage(driver, timeOutInSeconds);


    @Test
    public void testLoginSendAndSearch() {
        String subject = "subject " + new Date().toString();

        gmailPage.visit();
        gmailPage.login(TestData.email, TestData.password);

        mailPage.send(TestData.email, subject);

        menuPage.refresh();

        menuPage.goToInbox();
        mailPage.assertMail(0, subject);

        menuPage.goToSent();
        mailPage.assertMail(0, subject);

        menuPage.goToInbox();
        mailPage.searchBySubject(subject);
        mailPage.assertMails(subject);
    }
}
