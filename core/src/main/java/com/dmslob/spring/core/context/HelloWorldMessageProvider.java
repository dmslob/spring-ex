package com.dmslob.spring.core.context;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldMessageProvider implements MessageProvider {

    public String getMessage() {
        return "Message";
    }
}
