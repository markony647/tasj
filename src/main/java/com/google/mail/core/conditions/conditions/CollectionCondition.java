package com.google.mail.core.conditions.conditions;

import com.google.mail.core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.google.mail.core.ConciseAPI.getWebDriver;


public abstract class CollectionCondition extends AbstractCondition<List<WebElement>> {

    @Override
    public List<WebElement> getWrappedEntity() {
        return getWebDriver().findElements(locator);
    }

    @Override
    public String identity() {
        return " elements";
    }
}
