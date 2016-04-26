package com.google.mail;

import com.google.mail.core.WebDriverAPI;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest extends WebDriverAPI {

    WebDriver driver = new FirefoxDriver();

    @After
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
