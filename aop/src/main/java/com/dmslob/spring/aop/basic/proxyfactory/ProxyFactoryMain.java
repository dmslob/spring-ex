package com.dmslob.spring.aop.basic.proxyfactory;

import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryMain {

    public static void main(String[] args) {

        MessageWriter target = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new MessageDecorator());
        proxyFactory.setTarget(target);

        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();

        target.writeMessage();
        System.out.println();

        proxy.writeMessage();
    }
}
