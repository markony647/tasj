package core.entities.element;

import core.conditions.Condition;
import core.entities.LazyEntity;
import org.openqa.selenium.*;

public interface LazyElement extends LazyEntity<WebElement>, WebElement {

    LazyElement shouldBe(Condition<WebElement>... conditions);

    LazyElement should(Condition<WebElement>... conditions);

    LazyElement shouldHave(Condition<WebElement>... conditions);

    boolean is(Condition<WebElement> condition);

    boolean has(Condition<WebElement> condition);

    LazyElement setValue(String text);

    LazyElement pressEnter();

    LazyElement pressEscape();

    LazyElement hover();

    LazyElement doubleClick();

    LazyElement $(By locator);

    LazyElement $(String cssSelector);

    LazyElement find(String innerCssSelector);

    LazyElement find(By innerLocator);
}
