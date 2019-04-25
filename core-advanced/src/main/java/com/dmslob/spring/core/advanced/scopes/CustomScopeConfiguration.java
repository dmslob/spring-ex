package com.dmslob.spring.core.advanced.scopes;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("com.dmslob.spring.core.advanced.scopes")
public class CustomScopeConfiguration {

    /**
     * {@link CustomScopeConfigurer} bean is used to register custom scope with Spring {@link org.springframework.beans.factory.BeanFactory}.
     * It uses the general extension mechanism (implements {@link org.springframework.beans.factory.config.BeanFactoryPostProcessor} interface).
     * <br/><br/>
     * Note: since <c>BeanFactoryPostProcessors</c> are configured and executed on early stages of Spring context setup, it should not contain
     * any injected dependencies (it is possible to inject beans into CustomScopeConfigurer through xml-configuration, but it is not recomended,
     * since this beans would be created prior to full factory initialization and not all annotations may work as expected, since not all
     * post-processors are initialized).
     */
    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();

        Map<String, Object> customScopes = new HashMap<>();
        // Class<Scope>, String(class name) or instance of Scope can be passed as value
        customScopes.put(SharedContextScope.NAME, SharedContextScope.class);

        configurer.setScopes(customScopes);
        return configurer;
    }
}
