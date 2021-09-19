package com.pixily.movielab.repositories;

import com.pixily.movielab.model.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveMongoRepository<Movie, Integer> {
    Flux<Movie> findByTitle(final String title);
}
