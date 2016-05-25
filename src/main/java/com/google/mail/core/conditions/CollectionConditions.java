package com.google.mail.core.conditions;

import com.google.mail.core.conditions.conditions.Texts;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CollectionConditions {

    public static Condition<List<WebElement>> texts(final String... expectedTexts) {
        return new Texts(expectedTexts);
    }


}
