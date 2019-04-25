package com.dmslob.spring.core.di;

public interface MovieFinderFactory {
    MovieFinder getInstance(String type);
}
