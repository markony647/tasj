package core;


import core.conditions.Condition;
import core.entities.LazyElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class WithWaitFor {

    private LazyElement lazyElement;
    private Condition<WebElement> elementCondition;

    public WithWaitFor(LazyElement lazyElement, Condition<WebElement> elementCondition) {
        this.lazyElement = lazyElement;
        this.elementCondition = elementCondition;
    }

    public <T> T run(Command<T> command) {
        try {
            return command.execute(lazyElement.getWrappedEntity());
        } catch (WebDriverException e) {
            return command.execute(WaitFor.until(lazyElement, elementCondition));
        }
    }
}
