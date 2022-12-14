package com.example.websitetest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class Config { // Configuration

    @Bean
    Set<String> id() {
        return new HashSet<>();
    }  // qwe

}
