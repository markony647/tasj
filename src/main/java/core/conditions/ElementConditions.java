package core.conditions;

import core.conditions.element.*;
import org.openqa.selenium.WebElement;

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

    public static Condition<WebElement> text(final String expectedText) {
        return new Text(expectedText);
    }

    public static Condition<WebElement> exactText(final String expectedText) {
        return new ExactText(expectedText);
    }
}
