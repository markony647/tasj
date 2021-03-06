package core.conditions.element;

import org.openqa.selenium.WebElement;


public class Present extends ElementCondition {
    private boolean result;

    @Override
    public boolean check(WebElement element) {
        result = (element != null);
        return result;
    }

    @Override
    public String expected() {
        return "present";
    }

    @Override
    public String actual() {
        return result ? "present" : "not present";
    }
}
