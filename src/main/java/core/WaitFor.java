package core;

import core.conditions.Condition;

import core.entities.LazyEntity;
import org.openqa.selenium.*;



public class WaitFor {

    private LazyEntity lazyEntity;
    private Exception lastError;

    public WaitFor(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    public <T> T until(final long timeoutMs, final Condition<T> condition) {

        final long startTime = System.currentTimeMillis();
        do {
            try {
                return condition.apply(lazyEntity);
            } catch (WebDriverException e) {
                lastError = e;
            }
            sleep(Configuration.pollingInterval);

        } while (System.currentTimeMillis() - startTime < timeoutMs);

        throw new TimeoutException(condition.getClass().getSimpleName() +
                "\nFailed while waiting for " +
                "\nTimeout: " + Configuration.timeoutMs / 1000 + "s." + condition, lastError);
    }

    public static <T> T until(LazyEntity lazyEntity, final Condition<T>... conditions) {
        T result = null;
        for (Condition<T> condition : conditions) {
            result = new WaitFor(lazyEntity).until(Configuration.timeoutMs, condition);
        }
        return result;
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
