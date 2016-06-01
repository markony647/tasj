package com.google.mail.core.conditions;

import com.google.mail.core.base.LazyEntity;


public interface Condition<T> {

    T apply(LazyEntity lazyEntity);


}

