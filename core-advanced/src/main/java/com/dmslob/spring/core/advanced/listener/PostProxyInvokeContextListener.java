package com.dmslob.spring.core.advanced.listener;

import com.dmslob.spring.core.advanced.annotations.PostProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;
import java.util.Arrays;

public class PostProxyInvokeContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LogManager.getLogger(PostProxyInvokeContextListener.class);

    @Autowired
    ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        ApplicationContext context = contextRefreshedEvent.getApplicationContext();

        String[] names = context.getBeanDefinitionNames();
        Arrays.stream(names).forEach(name -> {

            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();

            try {
                Class originClass = Class.forName(originalClassName);
                Method[] methods = originClass.getMethods();
                Arrays.stream(methods).forEach(originMethod -> {
                    if (originMethod.isAnnotationPresent(PostProxy.class)) {
                        LOGGER.info("invoke from listener start");
                        Object bean = context.getBean(name);
                        try {
                            Method currentMethod = bean.getClass().getMethod(originMethod.getName(), originMethod.getParameterTypes());
                            currentMethod.invoke(bean);
                        } catch (Exception e) {
                            LOGGER.error(e.getMessage());
                        }
                        LOGGER.info("invoke from listener end");
                    }
                });
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        });
    }
}
