package com.dmslob.spring.core.factorybean;

public class SimpleTool implements Tool {

    private int id;

    public SimpleTool(int id) {
        this.id = id;
    }

    public String getResult() {
        return "SimpleTool";
    }
}
