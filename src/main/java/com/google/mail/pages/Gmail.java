package com.google.mail.pages;

import org.openqa.selenium.Keys;

import static com.google.mail.core.ConciseAPI.$;
import static com.google.mail.core.ConciseAPI.open;
import static com.google.mail.core.ConciseAPI.setValue;


public class Gmail {


    public static void visit() {
        open("https://gmail.com");
    }

    public static void login(String email, String password) {
        setValue($("#Email"), email + Keys.ENTER);
        setValue($("#Passwd"), password + Keys.ENTER);
    }
}
