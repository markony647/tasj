package core.entities;

import core.conditions.Condition;
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

    LazyElement pressTab();

    LazyElement hover();

    LazyElement doubleClick();

    LazyElement $(By innerLocator);

    LazyElement $(String innerCssSelector);

    LazyElement find(String innerCssSelector);

    LazyElement find(By innerLocator);

    LazyCollection findAll(By innerLocator);

    LazyCollection findAll(String cssInnerLocator);

}
