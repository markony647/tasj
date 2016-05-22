package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;

import java.util.List;


public class CollectionConditions {

    public static Condition<List<WebElement>> texts(final String... expectedTexts) {
        return new Texts(expectedTexts);
    }

    public static Condition<List<WebElement>> visible() {
        return new VisibilityOfElements();
    }

    public static Condition<List<WebElement>> presenceOfElements() {
        return new PresentElements();
    }

}
