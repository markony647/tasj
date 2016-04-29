package com.google.mail.core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    public void open(String url) {
        getWebDriver().get(url);
    }

    public <T> T assertThat(ExpectedCondition<T> condition) {
        return assertThat(condition, Configuration.timeout);
    }

    public <T> T assertThat(ExpectedCondition<T> condition, long timeout) {
        return new WebDriverWait(getWebDriver(), timeout).until(condition);
    }

    public By byCss(String selector) {
        return By.cssSelector(selector);
    }

    public WebElement $(By by) {
        return assertThat(visibilityOfElementLocated(by));
    }

    public WebElement $(String selector) {
        return $(byCss(selector));
    }

    public By byText(String elementText) {
        return By.xpath(".//*/text()[normalize-space(.) = " + Quotes.escape(elementText) + "]/parent::*");
    }

}
