package com.dmslob.spring.core.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.dmslob.spring.core.context")
@PropertySource("classpath:application.properties")
public class HelloConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]{new ClassPathResource("application.properties")};
        pspc.setLocations(resources);
        pspc.setIgnoreUnresolvablePlaceholders(true);
        return pspc;
    }

    @Bean
    @Profile("prod") // -Dspring.profiles.active=dev
    public Person person() {
        return new Person("Uncle Bob");
    }

    @Value("${greeting.text}")
    public String greet;

    @Value("${greeting.preamble}")
    public String pre;

    @Bean
    public String greeting() {
        return greet;
    }

    @Bean
    public String preamble() {
        return pre;
    }
}

