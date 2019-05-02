package com.dmslob.spring.core.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
public class ContextBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization, " + o.getClass() + ", " + s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization, " + o.getClass() + ", " + s);
        return o;
    }
}
