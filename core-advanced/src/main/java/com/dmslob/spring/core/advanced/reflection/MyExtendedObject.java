package com.dmslob.spring.core.advanced.reflection;

import com.dmslob.spring.core.advanced.annotations.RunThisMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Illustrates that the inherited methods also come with annotations.
 */
public class MyExtendedObject extends MyObject {

    private static final Logger LOGGER = LogManager.getLogger(MyExtendedObject.class);

    @RunThisMethod // since no repeat() value is provided, the default will be used
    public void executeExtended() {
        LOGGER.info("MyExtendedObject.executeExtended() was called.");
        increment();
    }
}
