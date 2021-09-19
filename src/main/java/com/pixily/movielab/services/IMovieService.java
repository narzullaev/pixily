package com.pixily.movielab.services;

import com.pixily.movielab.model.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovieService {

    Mono<Movie> addMovie(Movie movie);

    Mono<Movie> findById(Integer id);

    Flux<Movie> findByTitle(String title);

    Flux<Movie> findAllMovies();

    Mono<Movie> updateMovie(Movie movie);

    Mono<Void> deleteMovie(Integer id);
}
