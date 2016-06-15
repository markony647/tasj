package myframework;


import org.openqa.selenium.TimeoutException;
import testconfigs.BaseTest;
import core.entities.LazyCollection;
import core.entities.LazyElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static core.ConciseAPI.*;
import static core.conditions.CollectionConditions.*;
import static core.conditions.ElementConditions.*;
import static helpers.todomvc.Task.aTask;
import static helpers.todomvc.TaskType.ACTIVE;
import static helpers.todomvc.TaskType.COMPLETED;
import static org.junit.Assert.assertTrue;
import static pages.todomvc.TodoMVC.givenAtActive;
import static pages.todomvc.TodoMVC.givenAtAll;

public class MyFrameworkTest extends BaseTest {
    static LazyCollection results = $$(".srg>.g");

    @Test
    public void testIterator() {

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
    public void testPresentConditionPositive() {
        open("http://google.com");
        $(By.name("q")).shouldBe(present());
    }

    @Test(expected = TimeoutException.class)
    public void testPresentConditionNegative() {
        open("http://google.com");
        $(By.name(".q")).shouldBe(present());
    }

    @Test
    public void testCssClassConditionPositive() {
        open("http://google.com");
        $(By.name("q")).setValue("aa").pressEnter();
        $("._wI").shouldHave(cssClass("_kk"));
    }

    @Test(expected = TimeoutException.class)
    public void testCssClassConditionNegative() {
        open("http://google.com");
        $(By.name("q")).setValue("aa").pressEnter();
        $("._wI").shouldHave(cssClass("kk"));
    }

    @Test
    public void testFindAllPositive() {
        givenAtAll(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"));
        $("#todo-list").findAll("li").first().shouldHave(exactText("a"));
    }

    @Test(expected = TimeoutException.class)
    public void testFindAllNegative() {
        givenAtAll(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"));
        $("#todo-list").findAll("li").get(1).shouldHave(exactText("a"));
    }

    static LazyCollection tasks = $$("#todo-list>li");

    @Test
    public void testFilterPositive() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"));
        tasks.filter(visible()).shouldHave(exactTexts("a", "b"));
    }

    @Test(expected = TimeoutException.class)
    public void testFilterNegative() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"));
        tasks.filter(visible()).shouldHave(exactTexts("c"));
    }

    @Test
    public void testFindPositive() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"));
        tasks.find(exactText("b")).shouldBe(visible());
    }

    @Test(expected = TimeoutException.class)
    public void testFindNegative() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"));
        tasks.find(exactText("c")).shouldBe(visible());
    }

    @Test
    public void testEmptyConditionPositive() {
        givenAtActive(aTask(COMPLETED, "a"), aTask(COMPLETED, "b"));
        tasks.filter(visible()).shouldBe(empty());
    }

    @Test(expected = TimeoutException.class)
    public void testEmptyConditionNegative() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(COMPLETED, "b"));
        tasks.filter(visible()).shouldBe(empty());
    }

    @Test
    public void testHiddenConditionPositive() {
        givenAtActive(aTask(COMPLETED, "a"), aTask(COMPLETED, "b"));
        tasks.first().shouldBe(hidden());
    }

    @Test(expected = TimeoutException.class)
    public void testHiddenConditionNegative() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"));
        tasks.first().shouldBe(hidden());
    }
}
