package com.google.mail.core.conditions;

import com.google.mail.core.conditions.ex.DescribesResult;
import org.openqa.selenium.*;


public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {


    protected By locator;

    public abstract T check(T entity);

    public abstract T getWrappedEntity();

    @Override
    public String toString() {
        return "\nExpected :" + expected() +
                "\nActual : " + actual();
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
