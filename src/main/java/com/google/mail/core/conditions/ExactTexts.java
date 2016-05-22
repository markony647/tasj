package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.mail.core.Helpers.getString;
import static com.google.mail.core.Helpers.getTexts;


public class ExactTexts extends CollectionCondition {
    protected String[] expectedTexts;
    protected List<String> actualTexts;
    protected List<WebElement> visibleElements;
    protected List<WebElement> elements;

    public ExactTexts(String... expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public List<WebElement> check(List<WebElement> entity) {
        actualTexts = new ArrayList<String>();
        visibleElements = new ArrayList<WebElement>();
        this.elements = entity;

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
    public String getExpectedResult() {
        return Arrays.toString(expectedTexts);
    }

    @Override
    public String getActualResult() {
        return getString(actualTexts);
    }
}
