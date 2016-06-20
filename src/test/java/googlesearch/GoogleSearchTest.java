package googlesearch;

import core.ConciseAPI;
import testconfigs.BaseTest;
import core.entities.LazyCollection;
import org.junit.Test;
import org.openqa.selenium.By;

import static core.ConciseAPI.*;
import static core.conditions.CollectionConditions.size;
import static core.conditions.ElementConditions.text;
import static core.conditions.ElementConditions.visible;
import static org.junit.Assert.assertTrue;


public class GoogleSearchTest extends BaseTest {
    LazyCollection results = $$(".srg>.g");

    @Test
    public void testSearchSeleniumHqPageFromGoogle() {
        open("http://google.com");

        $(By.name("q")).setValue("Selenium automates browsers").pressEnter();

        results.shouldHave(size(10));
        results.first().shouldHave(text("Selenium automates browsers"));

        results.first().$("h3>a").click();
        assertUrlContains("http://www.seleniumhq.org/");
    }
}
