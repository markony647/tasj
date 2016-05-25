package com.google.mail.core.conditions.element;


import org.openqa.selenium.WebElement;

public class CssClass extends ElementCondition {
    private String expectedCssClass;
    private String actualCssClass;

    public CssClass(String expectedCssClass) {
        this.expectedCssClass = expectedCssClass;
    }

    @Override
    public WebElement check(WebElement element) {
        actualCssClass = element.getAttribute("class");
        if (!expectedCssClass.equals(actualCssClass)) {
            return null;
        }
        return element;
    }

    @Override
    public String expected() {
        return expectedCssClass;
    }

    @Override
    public String actual() {
        return actualCssClass;
    }
}
