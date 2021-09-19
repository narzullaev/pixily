package com.pixily.movielab.controller;

import com.pixily.movielab.model.Movie;
import com.pixily.movielab.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;
import java.util.Map;


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
        return movieService.findAllMovies();
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Void>> deleteMovie(@PathVariable(value = "id") int id) {
        return movieService.deleteMovie(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
