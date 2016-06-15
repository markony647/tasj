package core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.List;


public class Size extends CollectionCondition {

    private int expectedSize;
    private int actualSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public boolean check(List<WebElement> elements) {
        actualSize = elements.size();
        return expectedSize == actualSize;
    }

    @Override
    public String expected() {
        return String.valueOf(expectedSize);
    }

    @Override
    public String actual() {
        return String.valueOf(actualSize);
    }
}
