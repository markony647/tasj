package com.google.mail.core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static com.google.mail.core.Helpers.getTexts;


public class ExactTexts extends CollectionCondition {
    protected String[] expectedTexts;
    protected List<String> actualTexts;


    public ExactTexts(String... expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {

        actualTexts = getTexts(elements);

        if (actualTexts.size() != expectedTexts.length) {
            return null;
        }

        for (int i = 0; i < expectedTexts.length; i++) {
            if (!checkElement(i)) {
                return null;
            }
        }
        return elements;
    }

    public boolean checkElement(int index) {
        return actualTexts.get(index).equals(expectedTexts[index]);
    }

    @Override
    public String expected() {
        return Arrays.toString(expectedTexts);
    }

    @Override
    public String actual() {
        return String.join(",", actualTexts);
    }
}
