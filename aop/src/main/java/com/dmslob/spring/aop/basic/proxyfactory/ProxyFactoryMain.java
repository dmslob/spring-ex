package com.dmslob.spring.aop.basic.proxyfactory;

import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryMain {

    public static void main(String[] args) {

        MessageWriter target = new MessageWriter();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new MessageDecorator());
        proxyFactory.setTarget(target);

        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();

        // original object
        target.writeMessage();
        System.out.println();

        // proxy
        proxy.writeMessage();
    }
}
