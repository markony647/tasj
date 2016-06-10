package core.entities;


import core.conditions.Condition;
import org.openqa.selenium.WebElement;

import java.util.List;


public interface LazyCollection extends LazyEntity<List<WebElement>>, Iterable<LazyElement> {

    LazyCollection should(Condition<List<WebElement>>... conditions);

    LazyCollection shouldHave(Condition<List<WebElement>>... conditions);

    LazyCollection shouldBe(Condition<List<WebElement>>... conditions);

    LazyElement get(int index);

    LazyCollection filter(Condition<WebElement> condition);

    LazyElement find(Condition<WebElement> condition);

    LazyElement first();

    int size();

    boolean isEmpty();

    String[] getTexts();
}
