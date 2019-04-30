package com.dmslob.spring.core.scope;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TenantScopeConfig {
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new TenantBeanFactoryPostProcessor();
    }

    @Scope("tenant")
    @Bean
    public TenantBean foo() {
        return new TenantBean("foo");
    }

    @Scope("tenant")
    @Bean
    public TenantBean bar() {
        return new TenantBean("bar");
    }
}
