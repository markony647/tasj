package core.entities.element;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LazyElementInnerElement extends AbstractLazyElement {

    private By innerLocator;
    private LazyElement lazyElement;

    public LazyElementInnerElement(By innerLocator, LazyElement lazyElement) {
        this.innerLocator = innerLocator;
        this.lazyElement = lazyElement;
    }

    @Override
    public WebElement getWrappedEntity() {
        return lazyElement.getWrappedEntity().findElement(innerLocator);
    }

    @Override
    public String toString() {
        return String.valueOf(innerLocator);
    }
}
