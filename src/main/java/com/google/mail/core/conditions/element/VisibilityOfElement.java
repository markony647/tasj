package com.google.mail.core.conditions.element;

import org.openqa.selenium.WebElement;

public class VisibilityOfElement extends ElementCondition {

    private WebElement element;

    @Override
    public WebElement check(WebElement e) {
        this.element = e;

        if (!element.isDisplayed()) {
            return null;
        }
        return element;
    }

    @Override
    public String expected() {
        return " visible";
    }

    @Override
    public String actual() {
        return String.valueOf(element);
    }
}
