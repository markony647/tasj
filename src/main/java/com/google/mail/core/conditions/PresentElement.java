package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;


public class PresentElement extends ElementCondition {
    private WebElement element;


    @Override
    public WebElement check(WebElement entity) {
        this.element = entity;
        if (element != null) {
            return element;
        }
        return null;
    }

    @Override
    public String getExpectedResult() {
        return " is presenceOfElements";
    }

    @Override
    public String getActualResult() {
        return "is not presenceOfElements";
    }
}
