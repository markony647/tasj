package core.entities.collection;


import core.WaitFor;
import core.conditions.Condition;
import core.entities.element.LazyElement;
import core.entities.element.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

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

    public LazyElement get(int index) {
        return new LazyWrappedWebElement(getWrappedEntity().get(index));
    }

    @Override
    public LazyElement first() {
        return get(0);
    }
}
