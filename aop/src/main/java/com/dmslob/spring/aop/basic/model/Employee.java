package com.dmslob.spring.aop.basic.model;

import com.dmslob.spring.aop.basic.aspect.Loggable;

public class Employee {

    private String name;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    @Loggable
    public void setName(String name) {
        this.name = name;
    }

    public void throwException() {
        throw new RuntimeException("Dummy Exception");
    }
}
