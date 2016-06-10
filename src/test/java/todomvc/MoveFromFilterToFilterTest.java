package todomvc;

import org.junit.Test;
import testconfigs.BaseTest;

import static helpers.todomvc.Task.aTask;
import static helpers.todomvc.TaskType.ACTIVE;
import static helpers.todomvc.TaskType.COMPLETED;
import static pages.todomvc.TodoMVC.*;


public class MoveFromFilterToFilterTest extends BaseTest {

    @Test
    public void testMoveFromAllToActiveFilter() {
        givenAtAll(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(ACTIVE, "c"), aTask(COMPLETED, "d"));

        filterActive();
        assertVisibleTasks("a", "b", "c");
        assertItemsLeft(3);
    }

    @Test
    public void testMoveFromAllToCompletedFilter() {
        givenAtAll(aTask(COMPLETED, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"));

        filterCompleted();
        assertVisibleTasks("a", "c");
        assertItemsLeft(1);
    }

    @Test
    public void testMoveFromActiveToAllFilter() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(COMPLETED, "b"), aTask(COMPLETED, "c"));

        filterAll();
        assertVisibleTasks("a", "b", "c");
        assertItemsLeft(1);
    }

    @Test
    public void testMoveFromActiveToCompletedFilter() {
        givenAtActive(aTask(ACTIVE, "a"), aTask(COMPLETED, "b"), aTask(ACTIVE, "c"), aTask(COMPLETED, "d"));

        filterCompleted();
        assertVisibleTasks("b", "d");
        assertItemsLeft(2);
    }

    @Test
    public void testMoveFromCompletedToAllFilter() {
        givenAtCompleted(aTask(ACTIVE, "a"), aTask(ACTIVE, "b"), aTask(ACTIVE, "c"), aTask(COMPLETED, "d"));

        filterAll();
        assertTasks("a", "b", "c", "d");
        assertItemsLeft(3);
    }

    @Test
    public void testMoveFromCompletedToActiveFilter() {
        givenAtCompleted(aTask(COMPLETED, "a"), aTask(ACTIVE, "b"), aTask(COMPLETED, "c"), aTask(COMPLETED, "d"));

        filterActive();
        assertVisibleTasks("b");
        assertItemsLeft(1);
    }
}
