package com.google.mail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;


public class CustomConditions {

    public static ExpectedCondition<Boolean> textsOf(final By locator, final String... expectedTexts) {
        return new ExpectedCondition<Boolean>() {
            private List<WebElement> elements;

            public Boolean apply(WebDriver driver) {
                boolean isEqualsText = false;
                int expectedSize = expectedTexts.length;
                if (!(driver.findElements(locator).size() == expectedSize)) {
                    return false;
                }

                elements = driver.findElements(locator);
                for (int i = 0; i < expectedTexts.length; i++) {
                    if (expectedTexts[i].equals(elements.get(i).getText())) {
                        isEqualsText = true;
                    } else {
                        isEqualsText = false;
                        break;
                    }
                }
                return isEqualsText;
            }

            @Override
            public String toString() {
                String differenceInTexts = "There is difference in text : \n";
                String expectedSizeTexts = " ||  expected size : " + expectedTexts.length;
                String actualSizeTexts = " ||  actual size : " + elements.size() + "\n";
                for (int i = 0; i < expectedTexts.length; i++) {
                    if (!(expectedTexts[i].equals(elements.get(i).getText()))) {
                        differenceInTexts += "Expected : " + "\'" + expectedTexts[i] + "\'" + " ||  Actual : " + "\'" + elements.get(i).getText() + "\'" + "\n";
                    }
                }
                return expectedSizeTexts + actualSizeTexts + "In element located : " + locator + "\n" + differenceInTexts;
            }
        };
    }

    public static ExpectedCondition<Boolean> listNthElementHasText(final By elementsLocator, final int index, final String text) {
        return new ExpectedCondition<Boolean>() {
            private List<WebElement> elements;

            public Boolean apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);

                if (elements.get(index).getText().equals(text)) {
                    return true;
                } else {
                    return false;
                }
            }

            public String toString() {
                return String.format("text \'%s\' to be present in element %s but found \'%s\'", text, elementsLocator, elements.get(index).getText());
            }
        };
    }


}
