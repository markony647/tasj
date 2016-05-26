package com.google.mail.core.conditions;

import org.openqa.selenium.*;


public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {


    protected By locator;

    public abstract T check(T entity);

    public abstract T getWrappedEntity();

    @Override
    public String toString() {
        return  getClass().getSimpleName() +
                "\nfor" + identity() + " found by: " + locator +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual());
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
