package com.dmslob.spring.core.di;

import java.util.Iterator;
import java.util.List;

public class MovieLister {

    private MovieFinder movieFinder;

    public MovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public Movie[] moviesDirectedBy(String director) {
        List<Movie> movies = movieFinder.findAll();
        for (Iterator it = movies.iterator(); it.hasNext(); ) {
            Movie movie = (Movie) it.next();
            if (!director.equals(movie.getDirector())) {
                it.remove();
            }
        }
        return (Movie[]) movies.toArray();
    }
}
