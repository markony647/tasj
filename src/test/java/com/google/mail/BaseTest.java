package com.google.mail;

import com.google.mail.core.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.google.mail.core.ConciseAPI.getWebDriver;
import static com.google.mail.core.ConciseAPI.setWebDriver;


public class BaseTest {

    @Before
    public void setup() {
        setWebDriver(new FirefoxDriver());
        Configuration.timeoutMs = 20000;
    }

    @After
    public void tearDown() {
        getWebDriver().quit();
    }
}
