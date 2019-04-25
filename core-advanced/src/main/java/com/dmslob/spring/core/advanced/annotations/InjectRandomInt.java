package com.dmslob.spring.core.advanced.annotations;

import com.dmslob.spring.core.advanced.bpp.InjectRandomIntAnnotationBeanPostProcessor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Simple annotations to be processed by {@link InjectRandomIntAnnotationBeanPostProcessor} class.
 * <p>
 * Note:
 * RetentionPolicy.RUNTIME should be set in order for the annotation to be available at runtime through Reflection API
 * RetentionPolicy.CLASS by default
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {

    int max() default 10;

    int min() default 0;
}
