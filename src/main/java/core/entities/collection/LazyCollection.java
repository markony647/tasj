package core.entities.collection;


import core.conditions.Condition;
import core.entities.LazyEntity;
import core.entities.element.LazyElement;
import org.openqa.selenium.WebElement;

import java.util.List;


public interface LazyCollection extends LazyEntity<List<WebElement>>, Iterable<LazyElement> {

    LazyCollection should(Condition<List<WebElement>>... conditions);

    LazyCollection shouldHave(Condition<List<WebElement>>... conditions);

    LazyCollection shouldBe(Condition<List<WebElement>>... conditions);

    LazyElement get(int index);

    LazyElement first();

    int size();

    boolean isEmpty();

    String[] getTexts();

}
