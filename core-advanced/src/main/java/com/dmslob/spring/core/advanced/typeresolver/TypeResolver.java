package com.dmslob.spring.core.advanced.typeresolver;

import org.springframework.core.ResolvableType;

import java.util.ArrayList;
import java.util.List;

public class TypeResolver {

    Store<String> stringStore = new StringStore();
    Store<Integer> integerStore = new IntegerStore();
    List<Store<String>> stores = new ArrayList<Store<String>>();

    public static void main(String[] args) {
        TypeResolver typeResolver = new TypeResolver();
        try {
            typeResolver.resolveType("stringStore");
            System.out.println();

            typeResolver.resolveType("integerStore");
            System.out.println();

            typeResolver.resolveType("stores");
            System.out.println();

        } catch (NoSuchFieldException e) {
            System.out.println(e.getMessage());
        }
    }

    void resolveType(String field) throws NoSuchFieldException {

        ResolvableType t1 = ResolvableType.forField(getClass().getDeclaredField(field));
        System.out.println(t1);

        ResolvableType t2 = t1.getGeneric();
        System.out.println(t2);

        ResolvableType t3 = t2.getGeneric();
        Class<?> c = t3.resolve();
        System.out.println(c);
    }
}

interface Store<T> {
    T getType();
}

class StringStore implements Store<String> {

    private String type = "String";

    public String getType() {
        return type;
    }
}

class IntegerStore implements Store<Integer> {

    private Integer type = 10;

    public Integer getType() {
        return type;
    }
}