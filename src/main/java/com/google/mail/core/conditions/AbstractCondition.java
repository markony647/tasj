package com.google.mail.core.conditions;

import org.openqa.selenium.*;


public abstract class AbstractCondition<T> implements Condition<T> {


    protected By locator;

    public abstract T check(T entity);

    public abstract T getWrappedEntity();

    public abstract String getWebEntityDescription();

    public abstract String getExpectedResult();

    public abstract String getActualResult();

    @Override
    public String toString() {
        return "\n" +
                "for " + getWebEntityDescription() + "\nFound by: " + locator +
                "\nExpected :" + getExpectedResult() +
                "\nActual : " + getActualResult();
    }

    public T apply(By locator) {
        this.locator = locator;
        try {
            return check(getWrappedEntity());
        } catch (StaleElementReferenceException | ElementNotVisibleException | IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return null;
    }
}
