package com.google.mail.core.conditions.element;

import org.openqa.selenium.WebElement;


public class PresentElement extends ElementCondition {
    private WebElement element;

    @Override
    public WebElement check(WebElement e) {
        this.element = e;

        if (element != null) {
            return element;
        }
        return null;
    }

    @Override
    public String expected() {
        return " present";
    }

    @Override
    public String actual() {
        return String.valueOf(element);
    }
}
