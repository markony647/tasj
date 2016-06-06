package com.google.mail;

import core.BaseTest;
import core.Configuration;
import com.google.mail.pages.Gmail;
import com.google.mail.pages.Mail;
import com.google.mail.pages.Menu;
import com.google.testdata.TestData;
import org.junit.Test;

import java.util.Date;


public class GmailTest extends BaseTest {

    {
        Configuration.timeoutMs = 20000;
    }

    @Test
    public void testLoginSendAndSearch() {

        String subject = "subject " + new Date().toString();

        Gmail.visit();
        Gmail.login(TestData.email, TestData.password);

        Mail.send(TestData.email, subject);

        Menu.refresh();

        Menu.goToInbox();
        Mail.assertMail(0, subject);
        Menu.goToSent();
        Mail.assertMail(0, subject);

        Menu.goToInbox();
        Mail.searchBySubject(subject);
        Mail.assertMails(subject);
    }
}
