package com.google.mail.core.conditions;

import com.google.mail.core.LazyEntity;


public interface Condition<T> {

    T apply(LazyEntity lazyEntity);


}

