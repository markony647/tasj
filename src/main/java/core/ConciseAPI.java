package core;


import core.entities.collection.LazyWebDriverCollection;
import core.entities.element.LazyWebDriverElement;
import core.entities.LazyCollection;
import core.entities.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

    public static LazyElement $(By locator) {
        return new LazyWebDriverElement(locator);
    }

    public static LazyElement $(String selector) {
        return $(byCss(selector));
    }

    public static LazyCollection $$(By locator) {
        return new LazyWebDriverCollection(locator);
    }

    public static LazyCollection $$(String cssSelector) {
        return $$(byCss(cssSelector));
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

    public static String url () {
        return getWebDriver().getCurrentUrl();
    }
}