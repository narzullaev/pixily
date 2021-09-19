package com.pixily.movielab.model;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
@Getter
@Setter
public class MovieInfo {

    private int releaseYear;
    @NotNull
    private List<String> genres;
    private int duration;
    @NotNull
    private String description;
    private double rating;
    private int votes;


}
