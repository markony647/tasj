package core.conditions.element;

import org.openqa.selenium.WebElement;


public class Enabled extends ElementCondition {

    private boolean result;

    @Override
    public boolean check(WebElement element) {
        result = element.isEnabled();

        return result;
    }

    @Override
    public String expected() {
        return "enabled";
    }

    @Override
    public String actual() {
        return result ? "enabled" : "disabled";
    }
}
