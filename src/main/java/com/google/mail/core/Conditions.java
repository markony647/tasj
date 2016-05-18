package com.google.mail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.mail.core.Helpers.getTexts;


public class Conditions<T> extends AbstractCondition<T> {
    private static WebDriver driver;

    public Conditions(WebDriver driver) {
        Conditions.driver = driver;
    }

    public static Condition<WebElement> nthElementHasText(final int index, final String expectedText) {
        return new Condition<WebElement>() {
            private WebElement element;
            private String actualText;

            @Override
            public WebElement apply(By locator) {
                element = driver.findElements(locator).get(index);
                actualText = element.getText();
                if (actualText.contains(expectedText)) {
                    return element;
                }
                return null;
            }


            public String toString() {
                return String.format("Text mismatch \nExpected text: \'%s\' \nActual text: \'%s\'", expectedText, actualText);
            }
        };
    }


    public static Condition<List<WebElement>> texts(final String... expectedTexts) {
        return new Condition<List<WebElement>>() {
            private List<WebElement> elements;
            private List<String> actualTexts;

            @Override
            public List<WebElement> apply(By locator) {

                actualTexts = new ArrayList<String>();
                elements = driver.findElements(locator);

                actualTexts = getTexts(elements);

                if (actualTexts.size() != expectedTexts.length) {
                    return null;
                }

                for (int i = 0; i < expectedTexts.length; i++) {
                    if (!(actualTexts.get(i).contains(expectedTexts[i]))) {
                        return null;
                    }
                }
                return elements;
            }

            @Override
            public String toString() {
                return String.format("Texts mismatch \n Actual: %s \nExpected: %s", actualTexts, Arrays.toString(expectedTexts));
            }
        };
    }

    public static Condition<List<WebElement>> visibleExactTexts(final String... expectedTexts) {
        return new Condition<List<WebElement>>() {
            private List<String> actualTexts;
            private List<WebElement> visibleElements;
            private List<WebElement> elements;

            @Override
            public List<WebElement> apply(By locator) {

                actualTexts = new ArrayList<String>();
                visibleElements = new ArrayList<WebElement>();
                elements = driver.findElements(locator);

                for (WebElement e : elements) {
                    if (e.isDisplayed()) {
                        visibleElements.add(e);
                    }
                }

                actualTexts = getTexts(visibleElements);

                if (actualTexts.size() != expectedTexts.length) {
                    return null;
                }

                for (int i = 0; i < expectedTexts.length; i++) {
                    if (!actualTexts.get(i).equals(expectedTexts[i])) {
                        return null;
                    }
                }
                return visibleElements;
            }

            @Override
            public String toString() {
                return String.format("\n Texts mismatch \n Expected: %s \n Actual: %s", Arrays.toString(expectedTexts), actualTexts);
            }
        };
    }

    public static Condition<WebElement> listElementWithCssClass(final String cssClass) {
        return new Condition<WebElement>() {
            private List<String> actualCssClasses;
            private List<WebElement> elements;

            public WebElement apply(By locator) {
                actualCssClasses = new ArrayList<String>();

                elements = driver.findElements(locator);

                for (WebElement e : elements) {
                    actualCssClasses.add(e.getAttribute("class"));
                }

                for (int i = 0; i < actualCssClasses.size(); i++) {
                    String[] elementClasses = actualCssClasses.get(i).split(" ");
                    for (String elementClass : elementClasses) {
                        if (elementClass.equals(cssClass)) {
                            return elements.get(i);
                        }
                    }
                }
                return null;
            }

            @Override
            public String toString() {
                return String.format(" Expected css class: \'%s\' \n Actual: \'%s\'", cssClass, actualCssClasses);
            }
        };
    }


    @Override
    public T apply(By locator) {
        return waitUntil(locator, this);
    }

}
