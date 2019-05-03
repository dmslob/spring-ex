package com.dmslob.spring.core.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// The typical use case for BeanNameAware could be acquiring the bean name for logging or wiring purposes.
// For the BeanFactoryAware it could be the ability to use a spring bean from legacy code.
// In most cases, we should avoid using any of the Aware interfaces, unless we need them.
// Implementing these interfaces will couple the code to the Spring framework.

@Component
public class Walker implements InitializingBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public Walker() {
        System.out.println("constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationName: " + applicationContext.getStartupDate());
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
    }

    public void setBeanName(String s) {
        System.out.println("setBeanName: " + s);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("isSingleton: " + beanFactory.isSingleton("walker"));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}
