package com.google.mail.pages;


import com.google.mail.core.BasePage;
import org.openqa.selenium.WebDriver;


public class MenuPage extends BasePage {


    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void goToInbox() {
        $("a[title~='Inbox']").click();
    }

    public void goToSent() {
        $(byText("Sent Mail")).click();

    }

    public void refresh() {
        $("[title='Refresh']").click();
    }
}
