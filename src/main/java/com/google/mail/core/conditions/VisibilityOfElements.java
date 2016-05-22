package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;

import java.util.List;


public class VisibilityOfElements extends CollectionCondition {

    @Override
    public List<WebElement> check(List<WebElement> entity) {

        for (WebElement e : entity) {
            if (!e.isDisplayed()) {
                return null;
            }
        }
        return entity;
    }

    @Override
    public String getExpectedResult() {
        return " are visible";
    }

    @Override
    public String getActualResult() {
        return " are not visible";
    }
}
