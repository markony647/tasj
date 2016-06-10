package pages.todomvc;


import core.entities.LazyCollection;
import core.entities.LazyElement;
import helpers.todomvc.Filter;
import helpers.todomvc.Task;
import helpers.todomvc.TaskType;
import org.openqa.selenium.By;

import static core.ConciseAPI.*;
import static core.conditions.CollectionConditions.empty;
import static core.conditions.CollectionConditions.exactTexts;
import static core.conditions.ElementConditions.*;
import static helpers.todomvc.Task.aTasks;
import static helpers.todomvc.Task.prepareScript;

public class TodoMVC {

    static LazyCollection tasks = $$("#todo-list>li");

    public static void givenAtAll(Task... tasks) {
        givenAtFilter(Filter.ALL, tasks);
    }

    public static void givenAtAll(TaskType taskType, String... taskTexts) {
        givenAtFilter(Filter.ALL, taskType, taskTexts);
    }

    public static void givenAtCompleted(Task... tasks) {
        givenAtFilter(Filter.COMPLETED, tasks);
    }

    public static void givenAtCompleted(TaskType taskType, String... taskTexts) {
        givenAtFilter(Filter.COMPLETED, taskType, taskTexts);
    }

    public static void givenAtActive(Task... tasks) {
        givenAtFilter(Filter.ACTIVE, tasks);
    }

    public static void givenAtActive(TaskType taskType, String... taskTexts) {
        givenAtFilter(Filter.ACTIVE, taskType, taskTexts);
    }

    public static void givenAtFilter(Filter filter, Task... tasks) {
        ensurePageUrl(filter);
        executeJavaScript(prepareScript(tasks));
        executeJavaScript("location.reload()");
        $("#new-todo").shouldBe(enabled());
    }

    public static void givenAtFilter(Filter filter, TaskType taskType, String... taskTexts) {
        givenAtFilter(filter, aTasks(taskType, taskTexts));
    }

    public static void add(String... taskTexts) {
        for (String text : taskTexts) {
            $("#new-todo").setValue(text).pressEnter();
        }
    }

    public static LazyElement startEdit(String oldTaskText, String newTaskText) {
        tasks.find(exactText(oldTaskText)).find("label").doubleClick();
        return tasks.find(cssClass("editing")).$(".edit").setValue(newTaskText);
    }

    public static void toggle(String taskText) {
        tasks.find(exactText(taskText)).$(".toggle").click();
    }

    public static void toggleAll() {
        $("#toggle-all").click();
    }

    public static void delete(String taskText) {
        tasks.find(exactText(taskText)).hover().$(".destroy").click();
    }

    public static void clearCompleted() {
        $("#clear-completed").click();
    }

    public static void filterActive() {
        $(By.linkText("Active")).click();
    }

    public static void filterCompleted() {
        $(By.linkText("Completed")).click();
    }

    public static void filterAll() {
        $(By.linkText("All")).click();
    }

    public static void assertItemsLeft(int count) {
        $("#todo-count>strong").shouldHave(exactText(String.valueOf(count)));
    }

    public static void assertVisibleTasks(String... taskTexts) {
        tasks.filter(visible()).shouldHave(exactTexts(taskTexts));
    }

    public static void assertTasks(String... taskTexts) {
        tasks.shouldHave(exactTexts(taskTexts));
    }

    public static void assertNoTasks() {
        tasks.shouldBe(empty());
    }

    public static void assertNoVisibleTasks() {
        tasks.filter(visible()).shouldBe(empty());
    }

    public static void ensurePageUrl(Filter filterName) {
        if (!url().equals(filterName)) {
            open(filterName.getUrl());
        }
    }
}
