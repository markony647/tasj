package core.conditions.element;


import org.openqa.selenium.WebElement;

public class Hidden extends ElementCondition {
    private boolean result;

    @Override
    public boolean check(WebElement element) {
        result = !element.isDisplayed();
        return result;
    }

    @Override
    public String expected() {
        return "hidden";
    }

    @Override
    public String actual() {
        return result ? "hidden" : "not hidden";
    }
}
