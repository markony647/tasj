package com.google.mail.core;

import com.google.mail.core.conditions.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;


public class WaitFor {
    private By locator;

    public WaitFor(By locator) {
        this.locator = locator;
    }

    public <T> T until(final long timeoutMs, final Condition<T> condition) {
        final long startTime = System.currentTimeMillis();
        do {
            T result = condition.apply(locator);
            if (result == null) {
                sleep(Configuration.pollingInterval);
                continue;
            }
            return result;
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);

        throw new TimeoutException(condition.getClass() +
                "\nFailed while waiting for " +
                "\nTimeout: " + Configuration.timeoutMs / 1000 + "s." +
                condition +
                "\nFound by: " + locator);
    }

    public static <T> T until(By locator, final Condition<T>... conditions) {
        T result = null;
        for (Condition<T> condition : conditions) {
            result = new WaitFor(locator).until(Configuration.timeoutMs, condition);
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
