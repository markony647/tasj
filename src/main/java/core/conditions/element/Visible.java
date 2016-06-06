package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private boolean result;

    @Override
    public WebElement check(WebElement element) {
        result = element.isDisplayed();

        return element.isDisplayed() ? element : null;
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
