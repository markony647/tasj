package com.google.mail.core.conditions;


import com.google.mail.core.base.LazyEntity;
import org.openqa.selenium.*;


public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {


    private LazyEntity lazyEntity;


    public abstract T  check(T entity);


    @Override
    public String toString() {
        return  getClass().getSimpleName() +
                "\nfor" + identity() + " found by: " +lazyEntity.getClass().getSimpleName() +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual());
    }

    public T apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        try {
            return check( (T) lazyEntity.getWrappedEntity()) ;
        } catch (StaleElementReferenceException | ElementNotVisibleException | IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return null;
    }
}
