package com.dmslob.spring.core.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageEventListener implements ApplicationListener<MessageEvent> {

    public void onApplicationEvent(MessageEvent event) {
        MessageEvent messageEvent = (MessageEvent) event;
        System.out.println("Received: " + messageEvent.getMessage());
    }
}
