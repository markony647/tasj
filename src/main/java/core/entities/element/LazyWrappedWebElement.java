package core.entities.element;

import core.entities.LazyEntity;
import org.openqa.selenium.WebElement;


public class LazyWrappedWebElement extends AbstractLazyElement {

    private LazyEntity lazyEntity;
    private WebElement element;

    public LazyWrappedWebElement(LazyEntity lazyEntity, WebElement element) {
        this.lazyEntity = lazyEntity;
        this.element = element;
    }

    @Override
    public WebElement getWrappedEntity() {
        return element;
    }

    @Override
    public String toString() {
        return lazyEntity.toString();
    }
}
