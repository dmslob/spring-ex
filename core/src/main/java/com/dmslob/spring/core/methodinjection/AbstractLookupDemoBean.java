package com.dmslob.spring.core.methodinjection;

public abstract class AbstractLookupDemoBean implements DemoBean {

    public abstract MyHelper getMyHelper();

    public void someOperation() {
        getMyHelper().doSomeHelpful();
    }
}
