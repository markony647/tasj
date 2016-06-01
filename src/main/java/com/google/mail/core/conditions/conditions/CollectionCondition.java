package com.google.mail.core.conditions.conditions;

import com.google.mail.core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

import java.util.List;


public abstract class CollectionCondition extends AbstractCondition<List<WebElement>> {

    @Override
    public String identity() {
        return " elements";
    }
}
