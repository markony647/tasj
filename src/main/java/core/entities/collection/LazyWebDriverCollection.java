package core.entities.collection;


import core.entities.element.LazyElement;
import core.entities.element.LazyWrappedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static core.ConciseAPI.getWebDriver;


public class LazyWebDriverCollection extends AbstractLazyCollection {

    private By locator;

    public LazyWebDriverCollection(By locator) {
        this.locator = locator;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        return getWebDriver().findElements(locator);
    }


    @Override
    public Iterator<LazyElement> iterator() {
        List<WebElement> webElements = getWrappedEntity();

        List<LazyElement> lazyElements = new ArrayList<>();
        for (WebElement webElement : webElements) {
            lazyElements.add(new LazyWrappedWebElement(webElement));
        }
        return lazyElements.iterator();
    }

    public String toString() {
        return String.valueOf(locator);
    }

}
