package com.dmslob.spring.core.advanced.bfpp;

import com.dmslob.spring.core.advanced.annotations.DeprecatedClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger LOGGER = LogManager.getLogger(DeprecatedBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (String beanDefName : beanFactory.getBeanDefinitionNames()) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanDefName);
            Class<?> beanClass;
            try {
                beanClass = beanDefinition.resolveBeanClass(this.getClass().getClassLoader());
            } catch (ClassNotFoundException e) {
                LOGGER.info(e.getMessage());
                return;
            }
            DeprecatedClass deprecatedClassAnnotation = beanClass.getAnnotation(DeprecatedClass.class);
            if (deprecatedClassAnnotation == null) {
                continue;
            }
            Class<?> newClass = deprecatedClassAnnotation.newClass();
            beanDefinition.setBeanClass(newClass);
            LOGGER.info("Replaced " + beanClass.getName() + " with " + newClass.getName());
        }
    }
}
