package com.google.mail.pages;

import org.openqa.selenium.Keys;

import static com.google.mail.core.ConciseAPI.$;
import static com.google.mail.core.ConciseAPI.open;


public class Gmail {

    public Gmail() {
        System.out.println("Gmail Constructor");
    }

    public static  void visit() {
        open("https://gmail.com");
    }

    public static  void login(String email, String password) {

        $("#Email").sendKeys(email + Keys.ENTER);
        $("#Passwd").sendKeys(password + Keys.ENTER);

    }




}
