package com.dmslob.spring.core.advanced.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Illustrates that overridden methods also override the annotations.
 */
public class MyOverriddenObject extends MyObject {

    private static final Logger LOGGER = LogManager.getLogger(MyOverriddenObject.class);

    @Override
    public void executeMe() {
        LOGGER.info("MyOverriddenObject.executeMe() was called.");
    }
}
