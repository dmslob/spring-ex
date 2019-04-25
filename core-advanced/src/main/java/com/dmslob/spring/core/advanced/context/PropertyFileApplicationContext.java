package com.dmslob.spring.core.advanced.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {

    private static final Logger LOGGER = LogManager.getLogger(PropertyFileApplicationContext.class);

    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int i = reader.loadBeanDefinitions(fileName);
        LOGGER.info("Found: " + i + (i > 1 ? " beans" : " bean"));
        refresh();
    }
}
