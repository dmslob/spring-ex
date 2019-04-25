package com.dmslob.spring.core.advanced.quoters;

import com.dmslob.spring.core.advanced.annotations.DeprecatedClass;
import com.dmslob.spring.core.advanced.annotations.InjectRandomInt;
import com.dmslob.spring.core.advanced.annotations.Profiling;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;

@DeprecatedClass(newClass = T1000.class)
@Profiling
public class TerminatorQuoter implements Quoter {

    private static final Logger LOGGER = LogManager.getLogger(TerminatorQuoter.class);

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() {
        // will be 0
        // 1. create object
        // 2. Set up object
        LOGGER.info("Phase 1 Constructor, repeat = " + getRepeat());
    }

    // works on original method
    @PostConstruct
    public void init() {
        LOGGER.info("Phase 2 init(), repeat = " + repeat);
    }

    // getter and setter are needed for setting by xml properties
    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Destroy method doesn't work for prototype beans
    @Override
    //@PostProxy
    public void sayQuote() {
        LOGGER.info("Phase 3");
        for (int i = 0; i < repeat; i++) {
            LOGGER.info("Message: " + message);
        }
    }
}
