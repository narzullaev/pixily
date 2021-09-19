package com.pixily.movielab.controller;

import com.pixily.movielab.model.Movie;
import com.pixily.movielab.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class MovieController {

    private final MovieService movieService;
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Movie> addMovie(@RequestBody Movie movie) {
        LOGGER.info("addMovie invoked for -> " + movie);
        return movieService.addMovie(movie);
    }

    @GetMapping("/movies/{id}")
    public Mono<ResponseEntity<Movie>> findById(@PathVariable("id") Integer id) {
        return movieService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/movies/movie/{title}")
    public Flux<Movie> findByTitle(@PathVariable("title") String title) {
        return movieService.findByTitle(title);
    }

    @PutMapping("/movies")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Movie> updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @GetMapping("/movies")
    public Flux<Movie> findAll() {
        LOGGER.info("getAllMovies invoked");
        return movieService.findAllMovies();
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteMovie(@PathVariable(value = "id") int id) {
        LOGGER.info("deleteMovie invoked for movie ID -> " + id);
        return movieService.deleteMovie(id);
    }


}
