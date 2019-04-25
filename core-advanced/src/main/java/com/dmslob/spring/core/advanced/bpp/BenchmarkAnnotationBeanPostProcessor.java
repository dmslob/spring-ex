package com.dmslob.spring.core.advanced.bpp;

import com.dmslob.spring.core.advanced.annotations.Benchmark;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple <c>BeanPostProcessor</c> to illustrate the processing of custom annotation.
 * Uses JDK dynamic proxies to intercept method calls on bean objects.
 */
@Component
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {

    private static final Logger LOGGER = LogManager.getLogger(BenchmarkAnnotationBeanPostProcessor.class);

    private Map<String, Class> originalBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Benchmark.class)) {
            originalBeans.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        final Class<?> beanClass = bean.getClass();
        Class beanClassFromMap = originalBeans.get(beanName);
        if (beanClassFromMap != null) {
            LOGGER.info("beanClassFromMap.getName(): " + beanClassFromMap.getName());
        }
        if (beanClass.isAnnotationPresent(Benchmark.class)) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {

                long start = System.nanoTime();
                Object returnValue = ReflectionUtils.invokeMethod(method, bean, args);
                long end = System.nanoTime();

                LOGGER.info("==========================BenchmarkAnnotationBeanPostProcessor===========================");
                LOGGER.info(beanClass.getName() + "." + method.getName() + " timing: " + (end - start) + "ns");
                LOGGER.info("=========================================================================================");

                return returnValue;
            });
        }

        return bean;
    }
}
