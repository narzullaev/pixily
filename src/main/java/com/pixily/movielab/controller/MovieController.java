package com.pixily.movielab.controller;

import com.pixily.movielab.model.Movie;
import com.pixily.movielab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(value = "/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Movie> createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Movie>> findById(@PathVariable("id") String movie_id) {
        return movieService.findById(movie_id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/title/{title}")
    public Flux<Movie> findByTitle(@PathVariable("title") String title) {
        return movieService.findByTitle(title);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Movie> update(@RequestBody Movie movie) {
        return movieService.update(movie);
    }

    @GetMapping("/all")
    public Flux<Movie> findAll() {
        return movieService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") String movie_id) {
        movieService.delete(movie_id).subscribe();
    }


}
