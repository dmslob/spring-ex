package com.dmslob.spring.core.di;

import java.util.Arrays;

public class MovieFinderMain {

    public static void main(String[] args) {

        MovieFinderFactory finderFactory = new SimpleMovieFinderFactory();
        MovieFinder movieFinder = finderFactory.getInstance("colon");

        MovieLister movieLister = new MovieLister(movieFinder);
        Movie[] movies = movieLister.moviesDirectedBy("Uncle Bob");

        System.out.println(Arrays.toString(movies));
    }
}
