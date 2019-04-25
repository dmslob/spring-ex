package com.dmslob.spring.core.context;

public class HelloWorldMessageProvider implements MessageProvider {

    public String getMessage() {
        return "Message";
    }
}
