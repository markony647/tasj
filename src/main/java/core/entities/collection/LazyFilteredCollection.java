package core.entities.collection;


import core.conditions.Condition;
import core.entities.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class LazyFilteredCollection extends AbstractLazyCollection {

    private LazyCollection lazyCollection;
    private Condition<WebElement> elementCondition;

    public LazyFilteredCollection(LazyCollection lazyCollection, Condition<WebElement> elementCondition) {
        this.lazyCollection = lazyCollection;
        this.elementCondition = elementCondition;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        List<WebElement> actualElements = lazyCollection.getWrappedEntity();
        List<WebElement> resultElements = new ArrayList<>();

        for (int i = 0; i < actualElements.size(); i++) {
            if (elementCondition.apply(lazyCollection.get(i)) != null) {
                resultElements.add(actualElements.get(i));
            }
        }
        return resultElements;
    }

    @Override
    public String toString() {
        return lazyCollection.toString();
    }
}
