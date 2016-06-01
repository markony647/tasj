package com.google.mail.core.base;


import com.google.mail.core.WaitFor;
import com.google.mail.core.conditions.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.google.mail.core.ConciseAPI.getWebDriver;

public class Collection implements LazyCollection {

    private final By locator;

    public Collection(By locator) {
      this.locator=locator;
  }

    @Override
    public LazyCollection shouldHave(Condition<List<WebElement>>... condition) {
        WaitFor.until(this,condition);
        return this;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        return getWebDriver().findElements(locator);
    }
}
