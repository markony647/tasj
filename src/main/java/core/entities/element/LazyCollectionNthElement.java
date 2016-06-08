package core.entities.element;

import core.entities.collection.LazyCollection;
import org.openqa.selenium.WebElement;


public class LazyCollectionNthElement extends AbstractLazyElement {

    private int index;
    private LazyCollection lazyCollection;

    public LazyCollectionNthElement(int index, LazyCollection lazyCollection) {
        this.index = index;
        this.lazyCollection = lazyCollection;
    }

    @Override
    public WebElement getWrappedEntity() {
        return lazyCollection.getWrappedEntity().get(index);
    }

    @Override
    public String toString() {
        return lazyCollection.toString();
    }
}
