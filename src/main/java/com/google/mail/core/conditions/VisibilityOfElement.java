package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;


public class VisibilityOfElement extends ElementCondition {

    @Override
    public WebElement check(WebElement entity) {

        if (!entity.isDisplayed()) {
            return null;
        }
        return entity;
    }

    @Override
    public String getExpectedResult() {
        return  " visible";
    }

    @Override
    public String getActualResult() {
        return " is not visible";
    }
}
