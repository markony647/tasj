package com.google.mail.pages;


import static core.ConciseAPI.*;


public class Gmail {

    public static void visit() {
        open("https://gmail.com");
    }

    public static void login(String email, String password) {
        $("#Email").setValue(email).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }
}
