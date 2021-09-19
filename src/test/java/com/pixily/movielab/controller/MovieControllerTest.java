package com.pixily.movielab.controller;

import com.pixily.movielab.model.Movie;
import com.pixily.movielab.model.MovieInfo;
import com.pixily.movielab.services.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MovieController movieController;

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private MovieService service;

    @Test
    public void contextLoads() throws Exception {
        assertThat(movieController).isNotNull();
    }

    @Test
    public void addMovieTest() {
        Mono<Movie> movieMono = Mono.just(new Movie(2233, "Batman", getMovieInfo()));
        Movie movie = new Movie(2233, "Batman", getMovieInfo());
        when(service.addMovie(movie)).thenReturn(movieMono);

        webTestClient.post()
                .uri("/movies")
                .body(Mono.just(movieMono), Movie.class)
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    public void getAllMoviesTest() {
        Flux<Movie> movieFlux = Flux.just(new Movie(2233, "Batman", getMovieInfo()),
                new Movie(2244, "Batman", getMovieInfo()));
        when(service.findAllMovies()).thenReturn(movieFlux);

        Flux<Movie> movieBodyResponse = webTestClient.get()
                .uri("/movies")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Movie.class)
                .getResponseBody();

        StepVerifier.create(movieBodyResponse)
                .expectSubscription()
                .expectNext(new Movie(2233, "Batman", getMovieInfo()))
                .expectNext(new Movie(2244, "Batman", getMovieInfo()))
                .verifyComplete();
    }

    @Test
    public void getMovieByTitleTest(){
        Movie movie = new Movie(2233, "Batman", getMovieInfo());
        List<Movie> list = new ArrayList<>();
        list.add(movie);

        Flux<Movie> movieFlux  = Flux.fromIterable(list);

        Mockito
                .when(service.findByTitle("Batman"))
                .thenReturn(movieFlux);

        webTestClient.get()
                .uri("/movies/movie/{title}", "Batman")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Movie.class);

        Mockito.verify(service, Mockito.times(1)).findByTitle("Batman");
    }


    @Test
    public void getMovieByIdTest(){
        Mono<Movie> movieMono = Mono.just(new Movie(2233, "Batman", getMovieInfo()));
        when(service.findById(any())).thenReturn(movieMono);

        Flux<Movie> movieFlux = webTestClient.get()
                .uri("/movies/2233")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Movie.class)
                .getResponseBody();

        StepVerifier.create(movieFlux)
                .expectSubscription()
                .expectNextMatches(p->p.getTitle().equals("Batman"))
                .verifyComplete();

    }

    @Test
    public void deleteMovieTest(){
        given(service.deleteMovie(any())).willReturn(Mono.empty());
        webTestClient.delete()
                .uri("/movies/2233")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void updateMovieTest(){
        Mono<Movie> movieMono = Mono.just(new Movie(2233, "Batman", getMovieInfo()));
        Movie movie = new Movie(2233, "Batman", getMovieInfo());
        when(service.updateMovie(movie)).thenReturn(movieMono);

        webTestClient.put().uri("/movies")
                .body(Mono.just(movieMono),Movie.class)
                .exchange()
                .expectStatus().isOk();//200
    }

    private MovieInfo getMovieInfo() {
        return new MovieInfo(1992,
                "Superhero",
                65,
                "Batman Begins is part of Batman Dark Knight Triology",
                9.1, 1000);
    }

}
