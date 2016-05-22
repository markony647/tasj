package com.google.mail.core;


import com.google.mail.core.conditions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.currentThread;

public class ConciseAPI {
    private static Map<Thread, WebDriver> webDriversContainer = new HashMap<>();

    public static WebDriver getWebDriver() {
        return webDriversContainer.get(currentThread());
    }

    public static void setWebDriver(WebDriver driver) {
        webDriversContainer.put(currentThread(), driver);
    }

    public static void open(String url) {
        getWebDriver().get(url);
    }


    public static <T> T assertThat(By locator, Condition<T>... conditions) {
        return WaitFor.until(locator, conditions);
    }

//    public static List<WebElement> $$(By by) {
//        return assertThat(by, CollectionConditions.visible());
//    }

    public static WebElement $(By by) {
        return assertThat(by, ElementConditions.visible());
    }

    public static WebElement $(String selector) {
        return $(byCss(selector));
    }

    public static WebElement $(By selector, Condition<WebElement>... conditions) {
        return assertThat(selector, conditions);
    }

    public static WebElement $(String cssSelector, Condition<WebElement>... conditions) {
        return $(byCss(cssSelector), conditions);
    }

    public static WebElement $(By parentLocator, By innerElementLocator) {
        WebElement parentElement = $(parentLocator);
        return parentElement.findElement(innerElementLocator);
    }

    public static WebElement $(By parentLocator, String innerElementLocator) {
        return $(parentLocator, byCss(innerElementLocator));
    }

    public static By byCss(String selector) {
        return By.cssSelector(selector);
    }

    public static By byText(String elementText) {
        return By.xpath(".//*/text()[normalize-space(.) = " + Quotes.escape(elementText) + "]/parent::*");
    }

    public static Actions actions() {
        return new Actions(getWebDriver());
    }

    public static void executeJavaScript(String jsScript) {
        ((JavascriptExecutor) getWebDriver()).executeScript(jsScript);
    }

    public static WebElement doubleClick(WebElement element) {
        actions().doubleClick(element).perform();
        return element;
    }

    public static WebElement setValue(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        return element;
    }

    public static WebElement hover(WebElement element) {
        actions().moveToElement(element).perform();
        return element;
    }

}
