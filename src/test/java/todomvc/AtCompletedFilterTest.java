package todomvc;

import org.junit.Test;
import testconfigs.BaseTest;

import static helpers.todomvc.Task.aTask;
import static helpers.todomvc.TaskType.ACTIVE;
import static helpers.todomvc.TaskType.COMPLETED;
import static pages.todomvc.TodoMVC.*;


public class AtCompletedFilterTest extends BaseTest {

    @Test
    public void testCreateOnCompleted() {
        givenAtCompleted(COMPLETED, "a");

        add("b");
        assertVisibleTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testEditOnCompleted() {
        givenAtCompleted(COMPLETED, "a", "b");

        startEdit("a", "a edited").pressEnter();
        assertVisibleTasks("a edited", "b");
        assertItemsLeft(0);
    }

    @Test
    public void testDeleteOnCompleted() {
        givenAtCompleted(COMPLETED, "a", "b");

        delete("a");
        assertVisibleTasks("b");
        assertItemsLeft(0);
    }

    @Test
    public void testCompleteAllOnCompleted() {
        givenAtCompleted(ACTIVE, "a", "b");

        toggleAll();
        assertVisibleTasks("a", "b");
        assertItemsLeft(0);
    }

    @Test
    public void testReopenOnCompleted() {
        givenAtCompleted(COMPLETED, "a", "b");

        toggle("a");
        assertVisibleTasks("b");
        assertItemsLeft(1);
    }

    @Test
    public void testReopenAllOnCompleted() {
        givenAtCompleted(COMPLETED, "a", "b", "c", "d");

        toggleAll();
        assertNoVisibleTasks();
        assertItemsLeft(4);
    }

    @Test
    public void testClearCompletedOnCompleted() {
        givenAtCompleted(aTask(COMPLETED, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"), aTask(ACTIVE, "d"));

        clearCompleted();
        assertNoVisibleTasks();
        assertItemsLeft(2);
    }

    @Test
    public void testCancelEditByEscapeOnCompleted() {
        givenAtCompleted(aTask(COMPLETED, "a"), aTask(COMPLETED, "b"), aTask(ACTIVE, "c"));

        startEdit("b", "b edited").pressEscape();
        assertVisibleTasks("a", "b");
        assertItemsLeft(1);
    }

    @Test
    public void testDeleteByClearTextOnCompleted() {
        givenAtCompleted(aTask(COMPLETED, "a"), aTask(COMPLETED, "b"), aTask(ACTIVE, "c"));

        startEdit("a", " ").pressEnter();
        assertVisibleTasks("b");
        assertItemsLeft(1);
    }
}
