package core.conditions;


import core.entities.LazyEntity;
import org.openqa.selenium.*;


public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {

    private LazyEntity lazyEntity;

    public abstract T check(T entity);

    @Override
    public String toString() {
        return "\nfor" + identity() + " found by: " + lazyEntity +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual());
    }

    public T apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        try {
            return check((T) lazyEntity.getWrappedEntity());
        } catch (StaleElementReferenceException | ElementNotVisibleException | IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return null;
    }
}
