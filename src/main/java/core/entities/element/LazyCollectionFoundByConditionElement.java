package core.entities.element;


import core.conditions.Condition;
import core.entities.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyCollectionFoundByConditionElement extends AbstractLazyElement {

    private LazyCollection lazyCollection;
    private Condition<WebElement> elementCondition;

    public LazyCollectionFoundByConditionElement(LazyCollection lazyCollection, Condition<WebElement> elementCondition) {
        this.lazyCollection = lazyCollection;
        this.elementCondition = elementCondition;
    }

    @Override
    public WebElement getWrappedEntity() {
        List<WebElement> actualElements = lazyCollection.getWrappedEntity();

        for (int i = 0; i < actualElements.size(); i++) {
            if (elementCondition.apply(lazyCollection.get(i)) != null) {
                return actualElements.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return lazyCollection.toString();
    }
}
