package core.entities.element;

import core.entities.LazyCollection;
import core.exceptions.LazyСollectionIndexOutOfBoundsException;
import org.openqa.selenium.WebElement;


public class LazyCollectionNthElement extends AbstractLazyElement {

    private LazyCollection parentLazyCollection;
    private int index;

    public LazyCollectionNthElement(LazyCollection parentLazyCollection, int index) {
        this.parentLazyCollection = parentLazyCollection;
        this.index = index;
    }

    @Override
    public WebElement fetchWrappedEntity() {
        try {
            return parentLazyCollection.getWrappedEntity().get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new LazyСollectionIndexOutOfBoundsException(toString());
        }
    }

    @Override
    public String toString() {
        return parentLazyCollection + "\nby index: " + index;
    }
}
