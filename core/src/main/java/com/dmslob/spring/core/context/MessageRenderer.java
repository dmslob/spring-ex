package com.dmslob.spring.core.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageRenderer {

    private MessageProvider messageProvider;

    public MessageRenderer() {
    }

    @Autowired
    public MessageRenderer(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public String message() {
        return this.messageProvider.getMessage();
    }
}
