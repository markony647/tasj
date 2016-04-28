package com.google.mail;

import com.google.mail.core.ConciseAPI;
import com.google.mail.core.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest extends ConciseAPI {

    WebDriver driver = new FirefoxDriver();

    @Before
    public void setup() {
        Configuration.timeout = 20;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
