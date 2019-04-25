package com.dmslob.spring.core.di;

import java.util.HashMap;
import java.util.Map;

public class SimpleMovieFinderFactory implements MovieFinderFactory {

    private Map<String, MovieFinder> beans = new HashMap<String, MovieFinder>();

    public MovieFinder getInstance(String type) {
        if (beans.containsKey(type)) {
            MovieFinder movieFinderBean = beans.get(type);
            return movieFinderBean;
        } else {
            MovieFinder movieFinder = new ColonDelimetedMovieFinder();
            beans.put(type, movieFinder);
            return movieFinder;
        }
    }
}
