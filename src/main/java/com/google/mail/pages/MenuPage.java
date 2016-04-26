package com.google.mail.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver, long timeout) {
        super(driver, timeout);
    }

    public void goToInbox() {
        wait.until(elementToBeClickable(By.cssSelector("a[title~='Inbox']"))).click();
    }

    public void goToSent() {
        wait.until(elementToBeClickable(By.cssSelector("a[title='Sent Mail']"))).click();
    }

    public void refresh() {
        wait.until(elementToBeClickable(By.cssSelector("[title='Refresh']"))).click();
    }
}
