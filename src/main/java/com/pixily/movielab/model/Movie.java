package com.pixily.movielab.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    private int movieId;
    private String title;
    @NotNull
    private MovieInfo info;
}
