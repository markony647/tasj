package core.conditions;

import core.entities.LazyEntity;


public interface Condition<T> {

    T apply(LazyEntity lazyEntity);

}

