package com.dmslob.spring.core.di;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleMovieFinderFactory implements MovieFinderFactory {

    private Map<String, MovieFinder> beans = new HashMap<String, MovieFinder>();

    private FileSystemApplicationContextReader contextReader;

    public SimpleMovieFinderFactory(String contextPath) {
        this.contextReader = new FileSystemApplicationContextReader(contextPath);
    }

    public List<String> getLines() throws IOException {
        return contextReader.readLines();
    }

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

    public Object getObject() {
        Object bean = null;
        try {
            List<String> lines = getLines();
            lines.forEach(s -> {
                String line = s;
                if (line.startsWith("[")) {
                    StringBuilder stringBuilder = new StringBuilder(line);
                    stringBuilder.deleteCharAt(0);
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                    String[] beanDescription = stringBuilder.toString().split(":");
                    String className = beanDescription[0];
                    String beanName = beanDescription[1];

                    // create object

                    System.out.println(className);
                    System.out.println(beanName);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bean;
    }
}
