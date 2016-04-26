package com.google.mail.pages;

import com.google.mail.core.WebDriverAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends WebDriverAPI {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver, long timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }


    public void open(String url) {
        driver.get(url);
    }


    public WebDriver getWebDriver() {
        return driver;
    }

}
