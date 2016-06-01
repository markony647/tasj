package com.google.mail.core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.List;

// Отложил реализацию на будущее
public class NthElementHasText extends CollectionCondition {
    private int index;
    private String expectedText;

    public NthElementHasText(int index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;
    }

    @Override
    public List<WebElement> check(List<WebElement> entity) {
        return null;
    }

    @Override
    public String expected() {
        return "";
    }

    @Override
    public String actual() {
        return "";
    }


}


