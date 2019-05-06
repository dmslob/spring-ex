package com.dmslob.spring.aop.basic.proxyfactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Start...");
        Object retVal = invocation.proceed();
        System.out.println("Finish...");
        return retVal;
    }
}
