package com.dmslob.spring.core.advanced.beans;

import com.dmslob.spring.core.advanced.annotations.Benchmark;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Simple bean to illustrate the usage of custom {@link Benchmark} annotation
 */
@Benchmark
@Component("workflowReport")
public class WorkflowReport implements Report {

    private static final Logger LOGGER = LogManager.getLogger(WorkflowReport.class);

    @Override
    public void build() {
        LOGGER.info("some complex logic goes here");
    }
}
