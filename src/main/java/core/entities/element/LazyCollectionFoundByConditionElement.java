package core.entities.element;


import core.conditions.Condition;
import core.entities.LazyCollection;
import core.exceptions.ElementNotFoundException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyCollectionFoundByConditionElement extends AbstractLazyElement {

    private LazyCollection parentLazyCollection;
    private Condition<WebElement> elementCondition;

    public LazyCollectionFoundByConditionElement(LazyCollection parentLazyCollection, Condition<WebElement> elementCondition) {
        this.parentLazyCollection = parentLazyCollection;
        this.elementCondition = elementCondition;
    }

    @Override
    public WebElement fetchWrappedEntity() {
        List<WebElement> actualElements = parentLazyCollection.getWrappedEntity();

        for (WebElement element : actualElements) {
            if (elementCondition.check(element)) {
                return element;
            }
        }
        throw new ElementNotFoundException(toString());
    }

    @Override
    public String toString() {
        return parentLazyCollection.toString() + " find(" + elementCondition.getClass().getSimpleName() + ")";
    }
}
