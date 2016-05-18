package com.google.mail.core;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void setWebDriver(WebDriver driver) {

        ConciseAPI.driver = driver;
    }

    public static void open(String url) {
        getWebDriver().get(url);
    }

    public static <T> T assertThat(By locator, Condition<T> condition, long timeoutMs) {
        return new Conditions<T>(getWebDriver()).waitUntil(locator, condition, timeoutMs);
    }

    public static <T> T assertThat(By locator, Condition<T> condition) {
        return assertThat(locator, condition, Configuration.timeoutMs);
    }

    public static <T> T assertThat(ExpectedCondition<T> condition, long timeoutMs) {
        return new WebDriverWait(getWebDriver(), timeoutMs).until(condition);
    }

    public static <T> T assertThat(ExpectedCondition<T> condition) {
        return assertThat(condition, Configuration.timeoutMs);
    }

    public static WebElement $(By by) {
        return assertThat(visibilityOfElementLocated(by));
    }

    public static WebElement $(String selector) {
        return $(byCss(selector));
    }

    public static WebElement $(ExpectedCondition<WebElement> conditionToWaitElement) {
        return assertThat(conditionToWaitElement);
    }

    public static WebElement $(ExpectedCondition<WebElement> conditionToWaitParentElement, By innerElementLocator) {
        WebElement parentElement = assertThat(conditionToWaitParentElement);
        return parentElement.findElement(innerElementLocator);
    }

    public static WebElement $(ExpectedCondition<WebElement> conditionToWaitParentElement, String innerElementCssLocator) {
        return $(conditionToWaitParentElement, byCss(innerElementCssLocator));
    }

    public static List<WebElement> $$(ExpectedCondition<List<WebElement>> conditionToWaitForListFilteredElements) {
        return assertThat(conditionToWaitForListFilteredElements);
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
