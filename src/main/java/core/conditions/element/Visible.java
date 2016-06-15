package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private boolean result;

    @Override
    public boolean check(WebElement element) {
        result = element.isDisplayed();
        return result;
    }

    @Override
    public String expected() {
        return "visible";
    }

    @Override
    public String actual() {
        return result ? "visible" : "not visible";
    }
}
