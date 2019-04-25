package com.dmslob.spring.core.advanced.bpp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.dmslob.spring.core.advanced.bpp", "com.dmslob.spring.core.advanced.beans"})
public class BeanPostProcessorsConfiguration {
    // simple configuration
}
