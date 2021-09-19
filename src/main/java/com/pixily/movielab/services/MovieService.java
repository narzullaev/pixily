package com.pixily.movielab.services;

import com.pixily.movielab.repositories.MovieRepository;
import com.pixily.movielab.model.Movie;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService implements IMovieService {

    private final MovieRepository postRepository;

    public MovieService(MovieRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Mono<Movie> addMovie(Movie movie) {
        return postRepository.save(movie);
    }

    @Override
    public Mono<Movie> findById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public Flux<Movie> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public Flux<Movie> findAllMovies() {
        return postRepository.findAll();
    }

    @Override
    public Mono<Movie> updateMovie(Movie movie) {
        return postRepository.save(movie);
    }

    @Override
    public Mono<Void> deleteMovie(Integer id) {
        return postRepository.deleteById(id);
    }


}
