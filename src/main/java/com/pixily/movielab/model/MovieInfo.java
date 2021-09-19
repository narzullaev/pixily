package com.pixily.movielab.model;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieInfo {

    private int releaseYear;
    @NotNull
    private String genre;
    private int duration;
    @NotNull
    private String description;
    private double rating;
    private int votes;


}
