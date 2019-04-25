package com.dmslob.spring.aop.basic.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAnnotationAspect {

    @Before("@annotation(Loggable)")
    public void myAdvice() {
        System.out.println("Executing myAdvice!!");
    }
}
