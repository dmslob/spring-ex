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

@Component
public class Walker implements InitializingBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

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
