package com.dmslob.spring.core.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolConfig {

    @Bean(name = "simpleFactory")
    public SimpleToolFactory simpleFactory() {
        SimpleToolFactory factory = new SimpleToolFactory();
        factory.setFactoryId(7070);
        factory.setToolId(1);
        return factory;
    }

    @Bean(name = "complexFactory")
    public ComplexToolFactory complexFactory() {
        ComplexToolFactory factory = new ComplexToolFactory();
        factory.setFactoryId(7070);
        factory.setToolId(1);
        return factory;
    }

    @Bean
    public Tool simpleTool() throws Exception {
        return simpleFactory().getObject();
    }

    @Bean
    public Tool complexTool() throws Exception {
        return complexFactory().getObject();
    }
}
