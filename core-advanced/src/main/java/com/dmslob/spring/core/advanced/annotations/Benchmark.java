package com.dmslob.spring.core.advanced.annotations;

import com.dmslob.spring.core.advanced.bpp.BenchmarkAnnotationBeanPostProcessor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Simple annotation to be processed by {@link BenchmarkAnnotationBeanPostProcessor} class.
 * <p>
 * Note:
 * RetentionPolicy.RUNTIME should be set in order for the annotation to be available at runtime through Reflection API
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Benchmark {
}
