package com.google.mail.core.conditions;

import com.google.mail.core.conditions.conditions.NthElementHasText;
import org.openqa.selenium.WebElement;
import com.google.mail.core.conditions.element.*;

public class ElementConditions {
    public static Condition<WebElement> nthElementHasText(final int index, final String expectedText) {
        return new NthElementHasText(index, expectedText);
    }

    public static Condition<WebElement> visible() {
        return new VisibilityOfElement();
    }

    public static Condition<WebElement> cssClass(final String cssClass) {
        return new CssClass(cssClass);
    }

    public static Condition<WebElement> presenceOfElement() {
        return new PresentElement();
    }

}
