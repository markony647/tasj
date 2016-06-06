package core.conditions.element;

import core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;


public abstract class ElementCondition extends AbstractCondition<WebElement> {

    @Override
    public String identity() {
        return " element";
    }
}
