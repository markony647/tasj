package core.conditions.element;

import org.openqa.selenium.WebElement;


public class ExactText extends ElementCondition {

    protected String expectedText;
    protected String actualText;

    public ExactText(String expectedText) {
        this.expectedText = expectedText;
    }

    @Override
    public WebElement check(WebElement element) {
        actualText = element.getText();
        if (!checkElement()) {
            return null;
        }
        return element;
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
