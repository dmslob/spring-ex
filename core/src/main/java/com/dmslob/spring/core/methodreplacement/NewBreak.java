package com.dmslob.spring.core.methodreplacement;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class NewBreak implements MethodReplacer {

    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        // new property of Car.breaks() method.
        return "New car break.";
    }
}
