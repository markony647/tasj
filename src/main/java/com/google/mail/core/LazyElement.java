package com.google.mail.core;

import com.google.mail.core.conditions.Condition;
import org.openqa.selenium.*;


public interface LazyElement extends LazyEntity<WebElement>, WebElement {

    LazyElement shouldBe(Condition<WebElement>... condition);

    LazyElement setValue(String text);

    void pressEnter();

    void pressEscape();

    LazyElement hover();

    void doubleClick();
}
