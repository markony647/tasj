package com.google.mail.core;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

import static com.google.mail.core.Configuration.pollingInterval;


public abstract class AbstractCondition<T> implements Condition<T> {


    public <T> T waitUntil(By locator, Condition<T> condition, long timeoutMs) {
        final long startTime = System.currentTimeMillis();
        do {
            try {
                T result = condition.apply(locator);
                if (result == null) {
                    sleep(pollingInterval);
                    continue;
                }
                return result;
            } catch (WebDriverException elementNotFound) {
                elementNotFound.getMessage();

            }
            sleep(pollingInterval);
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);
        throw new TimeoutException("\n Locator: " + locator + "\n" + condition.toString());
    }

    public <T> T waitUntil(By locator, Condition<T> condition) {
        return waitUntil(locator, condition, Configuration.timeoutMs);
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
