package com.google.mail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class CustomConditions {

    public static ExpectedCondition<Boolean> textsToBePresentInElementLocated(final By locator, final String... expectedTexts) {
        return new ExpectedCondition<Boolean>() {


            public Boolean apply(WebDriver driver) {
                for (String expectedText : expectedTexts) {
                    return (driver.findElement(locator).getText().contains(expectedText));

                }
                return false;
            }

            @Override
            public String toString() {
                return String.format("text (\'%s\') to be present in element found by %s", expectedTexts, locator);
            }
        };
    }
}