package com.dmslob.spring.core.advanced.reflection;

import com.dmslob.spring.core.advanced.annotations.RunThisMethod;

import java.lang.reflect.Method;

/**
 * Simple annotation-processing factory. Illustrates the usage of Reflection API and Annotations parsing
 * to provide custom class initialization logic.
 */
public class ObjectFactory {

    /**
     * Method creates new instance of specified class and executes all methods marked by
     * {@link RunThisMethod} annotation.
     */
    public static <T> T newInstance(Class<T> clazz) throws Exception {
        T instance = clazz.newInstance();
        // find all methods, annotated with @RunThisMethod
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            RunThisMethod runThisMethod = method.getAnnotation(RunThisMethod.class);
            if (runThisMethod == null) {
                continue;
            }
            // repeat() is used to determine the required number of invocations
            for (int i = 0; i < runThisMethod.repeat(); i++) {
                method.invoke(instance);
            }
        }
        return instance;
    }
}
