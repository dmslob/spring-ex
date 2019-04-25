package com.dmslob.spring.aop.basic.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeXMLConfigAspect {

    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("EmployeeXMLConfigAspect:: Before invoking getName() method");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("EmployeeXMLConfigAspect:: After invoking getName() method. Return value=" + value);
        return value;
    }
}
