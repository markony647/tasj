package com.google.mail.pages;

import org.openqa.selenium.Keys;

import static com.google.mail.core.ConciseAPI.*;


public class Gmail {


    public static void visit() {
        open("https://gmail.com");
    }

    public static void login(String email, String password) {


        $("#Email").setValue(email + Keys.ENTER);
        $("#Passwd").setValue( password + Keys.ENTER);


     //   setValue($("#Email"), email + Keys.ENTER);
     //   setValue($("#Passwd"), password + Keys.ENTER);
    }
}
