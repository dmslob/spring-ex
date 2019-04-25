package com.dmslob.spring.core.advanced.bpp;

import com.dmslob.spring.core.advanced.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Simple <c>BeanPostProcessor</c> to illustrate the processing of custom annotation.
 * Sets the value of any annotated field to randomly generated number.
 * BeanPostProcessor - chain of responsibilities pattern
 */
@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    private final static Random random = new Random(System.currentTimeMillis());

    // Is called before init method
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();
                int randomNumber = random.nextInt(max - min) + min;

                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomNumber);
                //field.set(bean, randomNumber);
            }
        }
        return bean;
    }
    // between them:
    // init-method/afterPropertiesSet()/@PostConstruct

    // Is called after init method
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
