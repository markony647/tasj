package core.entities.element;

import core.entities.collection.LazyCollection;
import org.openqa.selenium.WebElement;


public class LazyCollectionNthElement extends AbstractLazyElement {

    private LazyCollection parentLazyCollection;
    private int index;

    public LazyCollectionNthElement(LazyCollection parentLazyCollection, int index) {
        this.parentLazyCollection = parentLazyCollection;
        this.index = index;
    }

    @Override
    public WebElement getWrappedEntity() {
        return parentLazyCollection.getWrappedEntity().get(index);
    }

    @Override
    public String toString() {
        return parentLazyCollection + "\nby index: " + index;
    }
}
