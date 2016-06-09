package core.entities.collection;


import core.entities.element.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LazyElementInnerCollection extends AbstractLazyCollection {

    private LazyElement parentLazyElement;
    private By parentInnerLocator;

    public LazyElementInnerCollection(LazyElement parentLazyElement, By parentInnerLocator) {
        this.parentLazyElement = parentLazyElement;
        this.parentInnerLocator = parentInnerLocator;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        return parentLazyElement.getWrappedEntity().findElements(parentInnerLocator);
    }

    @Override
    public String toString() {
        return parentLazyElement + "\ninner located: " + parentInnerLocator;
    }
}
