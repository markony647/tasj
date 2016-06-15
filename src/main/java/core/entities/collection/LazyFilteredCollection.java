package core.entities.collection;


import core.conditions.Condition;
import core.entities.LazyCollection;
import core.entities.element.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LazyFilteredCollection extends AbstractLazyCollection {

    private LazyCollection parentLazyCollection;
    private Condition<WebElement> elementCondition;

    public LazyFilteredCollection(LazyCollection parentLazyCollection, Condition<WebElement> elementCondition) {
        this.parentLazyCollection = parentLazyCollection;
        this.elementCondition = elementCondition;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        List<WebElement> actualElements = parentLazyCollection.getWrappedEntity();
        List<WebElement> resultElements = new ArrayList<>();

        for (WebElement element : actualElements) {
            if (elementCondition.check(element)) {
                resultElements.add(element);
            }
        }
        return resultElements;
    }

    @Override
    public String toString() {
        return  parentLazyCollection.toString() + " filter(" + elementCondition.getClass().getSimpleName() + ")";
    }
}
