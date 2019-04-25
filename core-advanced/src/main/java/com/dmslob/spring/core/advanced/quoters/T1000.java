package com.dmslob.spring.core.advanced.quoters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class T1000 extends TerminatorQuoter implements Quoter {

    private static final Logger LOGGER = LogManager.getLogger(T1000.class);

    //@PostProxy
    @Override
    public void sayQuote() {
        LOGGER.info("I am Liquid");
    }
}
