package myframework;


import testconfigs.BaseTest;
import core.entities.LazyCollection;
import core.entities.LazyElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static core.ConciseAPI.*;
import static core.conditions.CollectionConditions.exactTexts;
import static core.conditions.CollectionConditions.size;
import static core.conditions.ElementConditions.*;
import static org.junit.Assert.assertTrue;

public class MyFrameworkTest extends BaseTest {

    @Test
    public void testIterator() {
        LazyCollection results = $$(".srg>.g");

        open("https://www.google.com");
        $(By.name("q")).setValue("Selenium automates browsers").pressEnter();
        results.shouldHave(size(10));

        for (LazyElement element : results) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void testIsOfApplyingCondition() {
        open("http://gmail.com");
        $("#Email").shouldBe(visible());
        assertTrue($("#next").is(visible()));
    }

    @Test
    public void testPresentCondition() {
        open("http://googlesearch.com");
        $(By.name("q")).shouldBe(present());
    }

    @Test
    public void testCssClassCondition() {
        open("http://google.com");
        $(By.name("q")).setValue("aa").pressEnter();
        $("._wI").shouldHave(cssClass("_kk"));
    }

    @Test
    public void testFindAll() {
        LazyCollection footerParagraphs = $(".one-google").findAll("p");

        open("http://gmail.com");
        $("#Email").shouldBe(visible());
        footerParagraphs.shouldHave(exactTexts("Create account", "One Google Account for everything Google"));
    }
}
