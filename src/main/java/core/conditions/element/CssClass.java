package core.conditions.element;


import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class CssClass extends ElementCondition {
    private String expectedCssClass;
    private String[] actualCssClasses;

    public CssClass(String expectedCssClass) {
        this.expectedCssClass = expectedCssClass;
    }

    @Override
    public boolean check(WebElement element) {
        actualCssClasses = element.getAttribute("class").split(" ");
        for (int i = 0; i < actualCssClasses.length; i++) {
            if (expectedCssClass.equals(actualCssClasses[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String expected() {
        return expectedCssClass;
    }

    @Override
    public String actual() {
        return Arrays.toString(actualCssClasses);
    }
}
