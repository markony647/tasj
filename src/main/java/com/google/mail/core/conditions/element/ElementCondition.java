package com.google.mail.core.conditions.element;

import com.google.mail.core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;


public abstract class ElementCondition extends AbstractCondition<WebElement> {

    @Override
    public String identity() {
        return " element";
    }
}
