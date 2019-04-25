package com.dmslob.spring.core.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class ComplexToolFactory implements FactoryBean<Tool> {

    private int toolId;
    private int factoryId;

    public Tool getObject() throws Exception {
        toolId++;
        return new ComplexTool(toolId);
    }

    public Class<?> getObjectType() {
        return Tool.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }
}
