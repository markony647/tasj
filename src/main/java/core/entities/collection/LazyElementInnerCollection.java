package core.entities.collection;


import core.entities.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LazyElementInnerCollection extends AbstractLazyCollection {

    private LazyElement parentLazyElement;
    private By innerLocator;

    public LazyElementInnerCollection(LazyElement parentLazyElement, By innerLocator) {
        this.parentLazyElement = parentLazyElement;
        this.innerLocator = innerLocator;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        return parentLazyElement.getWrappedEntity().findElements(innerLocator);
    }

    @Override
    public String toString() {
        return parentLazyElement + "\ninner located: " + innerLocator;
    }
}
