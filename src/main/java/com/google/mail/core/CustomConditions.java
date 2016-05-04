package com.google.mail.core;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.*;


public class CustomConditions {

    public static ExpectedCondition<List<WebElement>> textsOf(final By locator, final String... expectedTexts) {
        return elementExceptionsCatcher(new ExpectedCondition<List<WebElement>>() {
            private List<WebElement> elements;
            private List<String> actualTexts;

            public List<WebElement> apply(WebDriver driver) {
                actualTexts = new ArrayList<String>();
                elements = driver.findElements(locator);

                for (WebElement e : elements) {
                    actualTexts.add(e.getText());
                }

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
                return String.format("\n Texts mismatch \n Actual : %s \n Expected: %s \n Element located  %s", actualTexts, Arrays.toString(expectedTexts), locator);
            }
        });
    }

    public static ExpectedCondition<Boolean> listNthElementHasText(final By elementsLocator, final int index, final String text) {
        return elementExceptionsCatcher(new ExpectedCondition<Boolean>() {
            private List<WebElement> elements;

            public Boolean apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);
                return (elements.get(index).getText().contains(text));
            }

            @Override
            public String toString() {
                return String.format("text \'%s\' to be present in element %s but found \'%s\'", text, elementsLocator, elements.get(index).getText());
            }
        });
    }

    public static <V> ExpectedCondition<V> elementExceptionsCatcher(final Function<? super WebDriver, V> condition) {
        return new ExpectedCondition<V>() {
            public V apply(WebDriver driver) {
                try {
                    return condition.apply(driver);
                } catch (StaleElementReferenceException e) {
                    return null;
                } catch (ElementNotVisibleException e) {
                    return null;
                } catch (IndexOutOfBoundsException e) {
                    return null;
                } catch (TimeoutException e) {
                    return null;
                } catch (NullPointerException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return condition.toString();
            }
        };
    }
}
