package com.pixily.movielab.services;

import com.pixily.movielab.repositories.MovieRepository;
import com.pixily.movielab.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository postRepository;

    @Override
    public Mono<Movie> createMovie(Movie movie) {
        return postRepository.save(movie);
    }

    @Override
    public Mono<Movie> findById(final String id) {
        return postRepository.findById(id);
    }

    @Override
    public Flux<Movie> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public Flux<Movie> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Mono<Movie> update(Movie movie) {
        return postRepository.save(movie);
    }

    @Override
    public Mono<Void> delete(String id) {
        return postRepository.deleteById(id);
    }
}
