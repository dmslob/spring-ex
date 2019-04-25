package com.dmslob.spring.core.methodinjection;

public class StandardLookupDemoBean implements DemoBean {

    private MyHelper myHelper;

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    public MyHelper getMyHelper() {
        return this.myHelper;
    }

    public void someOperation() {
        myHelper.doSomeHelpful();
    }
}
