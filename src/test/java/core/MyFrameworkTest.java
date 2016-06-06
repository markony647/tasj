package core;


import core.entities.collection.LazyCollection;
import core.entities.element.LazyElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static core.ConciseAPI.$;
import static core.ConciseAPI.$$;
import static core.ConciseAPI.open;
import static core.conditions.CollectionConditions.size;
import static core.conditions.ElementConditions.cssClass;
import static core.conditions.ElementConditions.present;
import static core.conditions.ElementConditions.visible;
import static org.junit.Assert.assertTrue;

public class MyFrameworkTest extends BaseTest {

    @Test
    public void testIterator() {
        LazyCollection results = $$(".srg>.g");

        open("http://google.com/ncr");
        $(By.name("q")).setValue("Selenium automates browsers").pressEnter();
        results.shouldHave(size(10));

        for (LazyElement element : results) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void testIsOfApplyingCondition() {
        open("http://gmail.com");
        assertTrue($("#next").is(visible()));
    }

    @Test
    public void testPresentCondition() {
        open("http://google.com");
        $(By.name("q")).shouldBe(present());
    }

    @Test
    public void testCssClassCondition() {
        open("http://google.com");
        $( By.name("q")).setValue("aa").pressEnter();
        $("._wI").shouldHave(cssClass("_kk"));
    }
}
