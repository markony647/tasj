package com.google.mail.core.conditions;

import org.openqa.selenium.WebElement;
import com.google.mail.core.conditions.element.*;

public class ElementConditions {


    public static Condition<WebElement> visible() {
        return new Visible();
    }

    public static Condition<WebElement> cssClass(final String cssClass) {
        return new CssClass(cssClass);
    }

    public static Condition<WebElement> present() {
        return new Present();
    }
}
