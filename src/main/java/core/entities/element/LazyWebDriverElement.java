package core.entities.element;

import core.ConciseAPI;
import org.openqa.selenium.*;


public class LazyWebDriverElement extends AbstractLazyElement {

    private By locator;

    public LazyWebDriverElement(By locator) {
        this.locator = locator;
    }

    @Override
    public WebElement fetchWrappedEntity() {
        return ConciseAPI.getWebDriver().findElement(locator);
    }

    @Override
    public String toString() {
        return String.valueOf(locator);
    }
}
