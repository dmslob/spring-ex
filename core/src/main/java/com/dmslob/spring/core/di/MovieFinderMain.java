package com.dmslob.spring.core.di;

import java.io.IOException;
import java.util.List;

public class MovieFinderMain {

    public static void main(String[] args) {

        String contextPath = "C:\\Users\\Dmytro_Slobodenyuk\\Desktop\\spring-ex\\core\\src\\main\\resources\\context.ini";

        MovieFinderFactory finderFactory = new SimpleMovieFinderFactory(contextPath);
        ((SimpleMovieFinderFactory) finderFactory).getObject();

        MovieFinder movieFinder = finderFactory.getInstance("colon");

        MovieLister movieLister = new MovieLister(movieFinder);
        List<Movie> movies = movieLister.moviesDirectedBy("Uncle Bob");

        //System.out.println(movies.toString());
    }
}
