package com.dmslob.spring.core.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.dmslob.spring.core.context")
public class HelloConfig {

    @Bean
    public Person person() {
        return new Person("Uncle Bob");
    }
}

