package com.dmslob.spring.core.factorybean;

public class ComplexTool implements Tool {

    private int id;

    public ComplexTool(int id) {
        this.id = id;
    }

    public String getResult() {
        return "ComplexTool";
    }
}
