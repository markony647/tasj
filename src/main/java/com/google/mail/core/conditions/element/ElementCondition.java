package com.google.mail.core.conditions.element;

import com.google.mail.core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

import static com.google.mail.core.ConciseAPI.getWebDriver;


public abstract class ElementCondition extends AbstractCondition<WebElement> {

    @Override
    public WebElement getWrappedEntity() {
        return getWebDriver().findElement(locator);
    }

    @Override
    public String identity() {
        return " element";
    }
}
