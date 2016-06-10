package todomvc;

import org.junit.Test;
import testconfigs.BaseTest;

import static core.ConciseAPI.$;
import static helpers.todomvc.Task.aTask;
import static helpers.todomvc.TaskType.ACTIVE;
import static helpers.todomvc.TaskType.COMPLETED;
import static pages.todomvc.TodoMVC.*;


public class AtActiveFilterTest extends BaseTest {

    @Test
    public void testCreateOnActive() {
        givenAtActive(aTask(COMPLETED, "a"), aTask(ACTIVE, "b"));

        add("c");
        assertVisibleTasks("b", "c");
        assertItemsLeft(2);
    }

    @Test
    public void testEditOnActive() {
        givenAtActive(ACTIVE, "a", "b");

        startEdit("b", "b edited").pressEnter();
        assertVisibleTasks("a", "b edited");
        assertItemsLeft(2);
    }

    @Test
    public void testDeleteOnActive() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"));

        delete("a");
        assertVisibleTasks("b");
        assertItemsLeft(1);
    }

    @Test
    public void testCompleteOnActive() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"));

        toggle("b");
        assertVisibleTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testCompleteAllOnActive() {
        givenAtActive(ACTIVE, "a", "b");

        toggleAll();
        assertNoVisibleTasks();
        assertItemsLeft(0);
    }

    @Test
    public void testReopenAllOnActive() {
        givenAtActive(COMPLETED, "a", "b", "c");

        toggleAll();
        assertVisibleTasks("a", "b", "c");
        assertItemsLeft(3);
    }

    @Test
    public void testClearCompletedOnActive() {
        givenAtActive(aTask(COMPLETED, "a"), aTask(COMPLETED, "b"), aTask(ACTIVE, "c"), aTask(ACTIVE, "d"));

        clearCompleted();
        assertVisibleTasks("c", "d");
        assertItemsLeft(2);
    }

    @Test
    public void testCancelEditByEscapeOnActive() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"));

        startEdit("a", "a edited").pressEscape();
        assertVisibleTasks("a", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testEditByClickOutsideOnActive() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"));

        startEdit("a", "a edited");
        $("#header").click();
        assertVisibleTasks("a edited", "b");
        assertItemsLeft(2);
    }
}
