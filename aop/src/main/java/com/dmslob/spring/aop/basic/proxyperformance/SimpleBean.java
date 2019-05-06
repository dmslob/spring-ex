package com.dmslob.spring.aop.basic.proxyperformance;

/**
 * Created by Dmytro_Slobodenyuk on 8/10/2018.
 */
public class SimpleBean implements ISimpleBean {

    private long dummy = 0;

    public void advised() {
        dummy = System.currentTimeMillis();
    }

    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
}
