package com.pixily.movielab.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.pixily.movielab.repositories")
public class DbConfig extends AbstractReactiveMongoConfiguration {

    @Value("${port}")
    String port;

    @Value("${dbname}")
    String dbname;

    @Override
    public @NotNull MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected @NotNull String getDatabaseName() {
        return dbname;
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(
                reactiveMongoClient(),
                getDatabaseName()
        );
    }

}
