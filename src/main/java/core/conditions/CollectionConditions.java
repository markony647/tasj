package core.conditions;

import core.conditions.collection.ExactTexts;
import core.conditions.collection.Size;
import core.conditions.collection.Texts;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CollectionConditions {

    public static Condition<List<WebElement>> texts(final String... expectedTexts) {
        return new Texts(expectedTexts);
    }

    public static Condition<List<WebElement>> exactTexts(final String... expectedTexts) {
        return new ExactTexts(expectedTexts);
    }

    public static Condition<List<WebElement>> size(final int size) {
        return new Size(size);
    }

    public static Condition<List<WebElement>> empty() {
        return new Size(0);
    }
}
