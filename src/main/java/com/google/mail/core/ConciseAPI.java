package com.google.mail.core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void setWebDriver(WebDriver input) {
        driver = input;
    }

    public static void open(String url) {
        getWebDriver().get(url);
    }

    public static <T> T assertThat(ExpectedCondition<T> condition) {
        return assertThat(condition, Configuration.timeout);
    }

    public static <T> T assertThat(ExpectedCondition<T> condition, long timeout) {
        return new WebDriverWait(getWebDriver(), timeout).until(condition);
    }

    public static By byCss(String selector) {
        return By.cssSelector(selector);
    }

    public static WebElement $(By by) {
        return assertThat(visibilityOfElementLocated(by));
    }

    public static WebElement $(String selector) {
        return $(byCss(selector));
    }

    public static By byText(String elementText) {
        return By.xpath(".//*/text()[normalize-space(.) = " + Quotes.escape(elementText) + "]/parent::*");
    }

}
