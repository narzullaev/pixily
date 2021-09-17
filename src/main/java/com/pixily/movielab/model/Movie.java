package com.pixily.movielab.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Movie {
    @Id
    private String movie_id;
    private String title;
    @NotNull
    private MovieInfo info;
}
