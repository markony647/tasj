package com.google.mail.core.conditions;

import com.google.mail.core.conditions.collection.ExactTexts;
import com.google.mail.core.conditions.collection.NthElementHasText;
import com.google.mail.core.conditions.collection.Texts;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CollectionConditions {

    public static Condition<List<WebElement>> texts(final String... expectedTexts) {
        return new Texts(expectedTexts);
    }

    public static Condition<List<WebElement>> exactTexts(final String... expectedTexts) {
        return new ExactTexts(expectedTexts);
    }

    public static Condition<List<WebElement>> nthElementHasText(final int index, final String expectedText) {
        return new NthElementHasText(index, expectedText);
    }
}
