package com.google.mail.core;


public class Configuration {

    /**
     * Timeout in milliseconds, uses to fail test when condition not met
     * Default value: 4000 milliseconds
     */
    public static long timeoutMs = 4000;

    /**
     * Interval in milliseconds, uses to check whether element is appeared
     * Default value: 100 milliseconds
     */
    public static long pollingInterval = 100;
}

