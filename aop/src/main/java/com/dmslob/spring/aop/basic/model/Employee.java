package com.dmslob.spring.aop.basic.model;

import com.dmslob.spring.aop.basic.aspect.Loggable;

public class Employee {

    private String name;

    public String getName() {
        return name;
    }

    @Loggable
    public void setName(String nm) {
        this.name = nm;
    }

    public void throwException() {
        throw new RuntimeException("Dummy Exception");
    }
}
