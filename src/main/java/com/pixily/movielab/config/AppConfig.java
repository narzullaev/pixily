package com.pixily.movielab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcePlaceholderConffigurer() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setLocation(new ClassPathResource("application.properties"));
        placeholderConfigurer.setIgnoreUnresolvablePlaceholders(true);

        return placeholderConfigurer;
    }

}
