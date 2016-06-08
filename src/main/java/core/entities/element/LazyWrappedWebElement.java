package core.entities.element;

import org.openqa.selenium.WebElement;


public class LazyWrappedWebElement extends AbstractLazyElement {

    private WebElement element;

    public LazyWrappedWebElement(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement getWrappedEntity() {
        return element;
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}
