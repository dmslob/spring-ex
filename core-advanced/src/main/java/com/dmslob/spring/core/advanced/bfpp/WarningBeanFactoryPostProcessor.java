package com.dmslob.spring.core.advanced.bfpp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Optional;

@Component
public class WarningBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger LOGGER = LogManager.getLogger(WarningBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            AbstractBeanDefinition definition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanName);
            String destroyMethodName = findDestroyMethodName(definition);

            if (destroyMethodName != null && definition.isPrototype()) {
                LOGGER.info("***** WARNING: " + beanName + " is prototype-scoped, method " + destroyMethodName + " will not be called.");
            }
        }
    }

    private String findDestroyMethodName(AbstractBeanDefinition beanDefinition) {
        if (beanDefinition instanceof AnnotatedBeanDefinition) {
            AnnotationMetadata metadata = ((AnnotatedBeanDefinition) beanDefinition).getMetadata();
            Optional<MethodMetadata> destroyMethod = metadata.getAnnotatedMethods(PreDestroy.class.getName()).stream().findFirst();

            if (destroyMethod.isPresent()) {
                return destroyMethod.get().getMethodName();
            }
        }
        return beanDefinition.getDestroyMethodName();
    }
}
