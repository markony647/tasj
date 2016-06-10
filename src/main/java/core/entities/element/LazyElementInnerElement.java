package core.entities.element;


import core.entities.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LazyElementInnerElement extends AbstractLazyElement {

    private By innerLocator;
    private LazyElement parentLazyElement;

    public LazyElementInnerElement(LazyElement parentLazyElement, By innerLocator) {
        this.parentLazyElement = parentLazyElement;
        this.innerLocator = innerLocator;
    }

    @Override
    public WebElement getWrappedEntity() {
        return parentLazyElement.getWrappedEntity().findElement(innerLocator);
    }

    @Override
    public String toString() {
        return parentLazyElement + "\ninner located: " + innerLocator;
    }
}
