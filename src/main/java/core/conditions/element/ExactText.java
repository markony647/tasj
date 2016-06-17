package core.conditions.element;

import org.openqa.selenium.WebElement;


public class ExactText extends ElementCondition {

    public String expectedText;
    public String actualText;

    public ExactText(String expectedText) {
        this.expectedText = expectedText;
    }

    @Override
    public boolean check(WebElement element) {
        actualText = element.getText();
        return checkElement();
    }

    public boolean checkElement() {
        return actualText.equals(expectedText);
    }

    @Override
    public String expected() {
        return expectedText;
    }

    @Override
    public String actual() {
        return actualText;
    }
}
