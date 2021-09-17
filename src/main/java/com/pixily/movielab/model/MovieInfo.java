package com.pixily.movielab.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieInfo {

    private int release_year;
    @NotNull
    private List<String> genres;
    private int duration;
    @NotNull
    private List<String> country;
    @NotNull
    private List<String> directors;
    @NotNull
    private List<String> actors;
    @NotNull
    private String description;
    private double rating;
    private int votes;


}
