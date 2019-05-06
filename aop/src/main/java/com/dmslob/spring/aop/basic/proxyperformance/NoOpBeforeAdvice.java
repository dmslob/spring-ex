package com.dmslob.spring.aop.basic.proxyperformance;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class NoOpBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        //System.out.println("NO-OP");
    }
}
