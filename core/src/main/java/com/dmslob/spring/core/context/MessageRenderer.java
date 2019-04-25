package com.dmslob.spring.core.context;

public class MessageRenderer {

    private MessageProvider messageProvider;

    public MessageRenderer() {
    }

    public MessageRenderer(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public String message() {
        String message = this.messageProvider.getMessage();
        System.out.println(message);
        return message;
    }
}
