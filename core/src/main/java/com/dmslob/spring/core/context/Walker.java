package com.dmslob.spring.core.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Walker implements InitializingBean, BeanNameAware, BeanFactoryAware, BeanPostProcessor, ApplicationContextAware {

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext.getApplicationName());
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
    }

    public void setBeanName(String s) {
        System.out.println("setBeanName: " + s);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory.isSingleton("walker"));
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization, " + o.getClass() + ", " + s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization, " + o.getClass() + ", " + s);
        return o;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}
