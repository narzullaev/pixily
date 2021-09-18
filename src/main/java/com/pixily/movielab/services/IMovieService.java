package com.pixily.movielab.services;

import com.pixily.movielab.model.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovieService {

    Mono<Movie> createMovie(Movie movie);

    Mono<Movie> findById(String id);

    Flux<Movie> findByTitle(String title);

    Flux<Movie> findAll();

    Mono<Movie> update(Movie movie);

    Mono<Void> delete(String id);
}
