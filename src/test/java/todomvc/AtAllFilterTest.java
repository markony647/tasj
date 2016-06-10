package todomvc;

import org.junit.Test;
import testconfigs.BaseTest;

import static helpers.todomvc.Task.aTask;
import static helpers.todomvc.TaskType.ACTIVE;
import static helpers.todomvc.TaskType.COMPLETED;
import static pages.todomvc.TodoMVC.*;


public class AtAllFilterTest extends BaseTest {

    @Test
    public void testTasksWorkFlow() {
        givenAtAll();

        add("a");
        startEdit("a", "a edited").pressEnter();
        assertTasks("a edited");
        assertItemsLeft(1);

        toggleAll();
        delete("a edited");
        assertNoTasks();
    }

    @Test
    public void testCompleteOnAll() {
        givenAtAll(ACTIVE, "a", "b");

        toggle("a");
        assertTasks("a", "b");
        assertItemsLeft(1);
    }

    @Test
    public void testReopenOnAll() {
        givenAtAll(aTask(ACTIVE, "a"), aTask(COMPLETED, "b"));

        toggle("b");
        assertTasks("a", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testReopenAllOnAll() {
        givenAtAll(COMPLETED, "a", "b");

        toggleAll();
        assertTasks("a", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testClearCompletedOnAll() {
        givenAtAll(aTask(ACTIVE, "a"), aTask(COMPLETED, "b"), aTask(COMPLETED, "c"));

        clearCompleted();
        assertTasks("a");
    }

    @Test
    public void testCancelEditByEscapeOnAll() {
        givenAtAll(aTask(COMPLETED, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"), aTask(ACTIVE, "d"));

        startEdit("d", "d edit").pressEscape();
        assertTasks("a", "b", "c", "d");
        assertItemsLeft(2);
    }

    @Test
    public void testEditByPressTabOnAll() {
        givenAtAll(aTask(COMPLETED, "a"), aTask(ACTIVE, "b"));

        startEdit("b", "b edited").pressTab();
        assertTasks("a", "b edited");
        assertItemsLeft(1);
    }
}
