package com.dmslob.spring.core.advanced.reflection;

import com.dmslob.spring.core.advanced.annotations.RunThisMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Sample annotated class to illustrate the custom annotations usage.
 */
public class MyObject {

    private static final Logger LOGGER = LogManager.getLogger(MyObject.class);

    /**
     * Holds the number of annotated methods execution (test purpose only)
     */
    private int callCount;

    public MyObject() {
        LOGGER.info("new " + this.getClass().getSimpleName() + " was created.");
    }

    @RunThisMethod(repeat = 2)
    public void executeMe() {
        LOGGER.info("MyObject.executeMe() was called.");
        increment();
    }

    protected void increment() {
        callCount++;
    }

    public int getCallCount() {
        return callCount;
    }
}
