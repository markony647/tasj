package com.google.mail.core.conditions.element;

import org.openqa.selenium.WebElement;

public class VisibilityOfElement extends ElementCondition {

    private boolean result;

    @Override
    public WebElement check(WebElement element) {
        result = (element.isDisplayed());

        return element.isDisplayed() ? element : null;
    }

    @Override
    public String expected() {
        return "visible";
    }

    @Override
    public String actual() {
        return result ? "visible" : "not visible";
    }
}
