package com.google.mail.core.base;


import com.google.mail.core.conditions.Condition;
import org.openqa.selenium.WebElement;

import java.util.List;


public interface LazyCollection extends LazyEntity<List<WebElement>> {

        LazyCollection shouldHave (Condition<List<WebElement>>...condition);
}
