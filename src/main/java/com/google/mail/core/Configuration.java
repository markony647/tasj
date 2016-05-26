package com.google.mail.core;


public class Configuration {

    /**
     * default interval for WaitFor.Until - smart waiting check one condition, in milliseconds
     */
    public static long timeoutMs = 4000;

    /**
     * default interval between checks inside WaitFor.Until, in milliseconds
     */
    public static long pollingInterval = 100;
}

