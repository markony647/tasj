package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.google.mail.core.ConciseAPI.getWebDriver;


public abstract class CollectionCondition extends AbstractCondition<List<WebElement>> {

    @Override
    public List<WebElement> getWrappedEntity() {
        return getWebDriver().findElements(locator);
    }

    public String getWebEntityDescription() {
        return "Elements: " + getElementsDescription();
    }

    public String getElementsDescription() {
        return getWrappedEntity().toString();
    }
}
