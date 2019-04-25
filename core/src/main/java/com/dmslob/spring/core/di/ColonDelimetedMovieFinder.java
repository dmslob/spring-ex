package com.dmslob.spring.core.di;

import java.util.ArrayList;
import java.util.List;

public class ColonDelimetedMovieFinder implements MovieFinder {

    private String filename;

    public ColonDelimetedMovieFinder() {

    }

    public ColonDelimetedMovieFinder(String filename) {
        this.filename = filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<Movie>();
        // TODO
        return movies;
    }
}
