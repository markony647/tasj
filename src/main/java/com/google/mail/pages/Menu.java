package com.google.mail.pages;


import static com.google.mail.core.ConciseAPI.$;
import static com.google.mail.core.ConciseAPI.byText;


public class Menu {

    public static void goToInbox() {
        $("a[title~='Inbox']").click();
    }

    public static void goToSent() {
        $(byText("Sent Mail")).click();

    }

    public static void refresh() {
        $("[title='Refresh']").click();
    }

}
