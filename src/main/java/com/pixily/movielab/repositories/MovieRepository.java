package com.pixily.movielab.repositories;

import com.pixily.movielab.model.Movie;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
    @Query("{'title';?0}")
    Flux<Movie> findByTitle(final String title);
}
