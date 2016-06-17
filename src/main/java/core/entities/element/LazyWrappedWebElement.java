package core.entities.element;

import core.entities.LazyEntity;
import org.openqa.selenium.WebElement;


public class LazyWrappedWebElement extends AbstractLazyElement {

    private LazyEntity parentLazyEntity;
    private WebElement element;

    public LazyWrappedWebElement(LazyEntity parentLazyEntity, WebElement element) {
        this.parentLazyEntity = parentLazyEntity;
        this.element = element;
    }

    @Override
    public WebElement fetchWrappedEntity() {
        return element;
    }

    @Override
    public String toString() {
        return "WebElement " + element + "from " + parentLazyEntity;
    }
}
