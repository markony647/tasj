package com.google.mail.pages;

import com.google.mail.core.conditions.ElementConditions;
import org.openqa.selenium.Keys;

import static com.google.mail.core.ConciseAPI.$;
import static com.google.mail.core.ConciseAPI.open;
import static com.google.mail.core.ConciseAPI.setValue;
import static com.google.mail.core.conditions.ElementConditions.presenceOfElement;


public class Gmail {


    public static void visit() {
        open("https://gmail.com");
    }

    public static void login(String email, String password) {
        setValue($( "#Email.."), email + Keys.ENTER);

        //setValue($("#Email"), email + Keys.ENTER);
        setValue($("#Passwd"), password + Keys.ENTER);
    }
}
