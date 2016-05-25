package com.google.mail.core.conditions.conditions;

import org.openqa.selenium.WebElement;
import com.google.mail.core.conditions.element.*;

// Отложил реализацию на будущее
public class NthElementHasText extends ElementCondition {
    private int index;
    private String expectedText;

    public NthElementHasText(int index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;
    }

    @Override
    public WebElement check(WebElement element) {
        return element;
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


