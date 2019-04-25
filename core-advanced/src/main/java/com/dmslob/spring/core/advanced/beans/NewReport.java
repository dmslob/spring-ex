package com.dmslob.spring.core.advanced.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NewReport implements Report {

    private static final Logger LOGGER = LogManager.getLogger(NewReport.class);

    @Override
    public void build() {
        LOGGER.info("NewReport.build() called.");
    }
}
