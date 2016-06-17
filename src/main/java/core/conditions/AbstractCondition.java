package core.conditions;


import core.entities.LazyEntity;
import core.exceptions.WebDriverAssertionException;


public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {

    private LazyEntity lazyEntity;

    @Override
    public String toString() {
        return "\nfor" + identity() + " found by: " + lazyEntity +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual());
    }

    @Override
    public T apply(LazyEntity lazyEntity) throws WebDriverAssertionException {
        this.lazyEntity = lazyEntity;
        T result = (T) lazyEntity.getWrappedEntity();
        if (check(result)) {
            return result;
        }
        throw new WebDriverAssertionException(toString());
    }
}
