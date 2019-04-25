package com.dmslob.spring.core.advanced.beans;

import com.dmslob.spring.core.advanced.annotations.DeprecatedClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("oldReport")
@DeprecatedClass(newClass = NewReport.class)
public class OldReport implements Report {

    private static final Logger LOGGER = LogManager.getLogger(OldReport.class);

    @Override
    public void build() {
        LOGGER.info("OldReport.build() called.");
    }
}
