package com.dmslob.spring.core.methodinjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyHelper {

    public void doSomeHelpful() {
        System.out.println("doSomeHelpful");
    }
}
