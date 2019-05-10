package com.dmslob.spring.aop.basic.cglib.mixin;

import org.springframework.cglib.proxy.Mixin;

public class MixinApp {

    public static void main(String[] args) {
        MixinApp app = new MixinApp();
        app.create();
    }

    private void create() {
        Mixin mixin = Mixin.create(
                new Class[]{Interface1.class, Interface2.class, MixinInterface.class},
                new Object[]{new Class1(), new Class2()}
        );
        MixinInterface mixinDelegate = (MixinInterface) mixin;

        System.out.println(mixinDelegate.first());
        System.out.println(mixinDelegate.second());
    }
}

interface Interface1 {
    String first();
}

interface Interface2 {
    String second();
}

class Class1 implements Interface1 {
    @Override
    public String first() {
        return "first behaviour";
    }
}

class Class2 implements Interface2 {
    @Override
    public String second() {
        return "second behaviour";
    }
}

interface MixinInterface extends Interface1, Interface2 {
}