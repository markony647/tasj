package com.google.mail.core.conditions.element;

import org.openqa.selenium.WebElement;


public class PresentElement extends ElementCondition {
    private boolean result;

    @Override
    public WebElement check(WebElement element) {
        result = (element != null);
        return element;
    }

    @Override
    public String expected() {
        return "present";
    }

    @Override
    public String actual() {
        return result ? "present" : "not present";
    }
}
