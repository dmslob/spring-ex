package com.dmslob.spring.core.context;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.dmslob.spring.core.context")
public class ContextConfig {

    @Bean
    public Person person() {
        return new Person("Uncle Bob");
    }
}

