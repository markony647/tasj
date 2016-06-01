package com.google.mail.core;


public interface LazyEntity<T> {

    T getWrappedEntity();

}
