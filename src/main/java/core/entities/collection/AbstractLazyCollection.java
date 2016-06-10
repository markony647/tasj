package core.entities.collection;


import core.WaitFor;
import core.conditions.Condition;
import core.entities.LazyCollection;
import core.entities.element.LazyCollectionFoundByConditionElement;
import core.entities.element.LazyCollectionNthElement;
import core.entities.LazyElement;
import core.entities.element.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class AbstractLazyCollection implements LazyCollection {

    @Override
    public LazyCollection should(Condition<List<WebElement>>... conditions) {
        WaitFor.until(this, conditions);
        return this;
    }

    @Override
    public LazyCollection shouldHave(Condition<List<WebElement>>... conditions) {
        return should(conditions);
    }

    @Override
    public LazyCollection shouldBe(Condition<List<WebElement>>... conditions) {
        return should(conditions);
    }

    @Override
    public abstract List<WebElement> getWrappedEntity();

    @Override
    public LazyElement get(int index) {
        return new LazyCollectionNthElement(this, index);
    }

    @Override
    public LazyElement first() {
        return get(0);
    }

    @Override
    public int size() {
        return getWrappedEntity().size();
    }

    @Override
    public boolean isEmpty() {
        return getWrappedEntity().size() == 0;
    }

    @Override
    public String[] getTexts() {
        String[] texts = new String[getWrappedEntity().size()];
        for (int i = 0; i < getWrappedEntity().size(); i++) {
            texts[i] = getWrappedEntity().get(i).getText();
        }
        return texts;
    }

    @Override
    public LazyCollection filter(Condition<WebElement> elementCondition) {
        return new LazyFilteredCollection(this, elementCondition);
    }

    @Override
    public LazyElement find(Condition<WebElement> elementCondition) {
        return new LazyCollectionFoundByConditionElement(this, elementCondition);
    }

    @Override
    public Iterator<LazyElement> iterator() {
        List<WebElement> webElements = getWrappedEntity();

        List<LazyElement> lazyElements = new ArrayList<>();
        for (WebElement webElement : webElements) {
            lazyElements.add(new LazyWrappedWebElement(this, webElement));
        }
        return lazyElements.iterator();
    }
}

