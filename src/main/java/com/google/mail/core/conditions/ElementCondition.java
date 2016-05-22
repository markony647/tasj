package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;

import static com.google.mail.core.ConciseAPI.getWebDriver;


public abstract class ElementCondition extends AbstractCondition<WebElement> {

    @Override
    public WebElement getWrappedEntity() {
        return getWebDriver().findElement(locator);
    }


    public WebElement getWebElementByIndex(int index) {
        return getWebDriver().findElements(locator).get(index);
    }

    public String getWebEntityDescription() {
        return "Element: " + getElementDescription();
    }

    public String getElementDescription() {
        return getWrappedEntity().toString();
    }
}
