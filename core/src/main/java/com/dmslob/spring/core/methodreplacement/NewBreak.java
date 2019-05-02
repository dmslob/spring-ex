package com.dmslob.spring.core.methodreplacement;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class NewBreak implements MethodReplacer {

    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        // new property of Car.breaks() method.
        return "New car break.";
    }
}
