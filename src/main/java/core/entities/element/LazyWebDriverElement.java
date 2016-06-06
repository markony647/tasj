package core.entities.element;

import core.ConciseAPI;
import org.openqa.selenium.*;


public class LazyWebDriverElement extends AbstractLazyElement {

    private By locator;

    public LazyWebDriverElement(By locator) {
        this.locator = locator;
    }

    @Override
    public WebElement getWrappedEntity() {
        return ConciseAPI.getWebDriver().findElement(locator);
    }

    public String toString() {
        return String.valueOf(locator);
    }
}
