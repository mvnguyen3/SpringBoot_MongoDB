package com.example.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.mongodb.repository", mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoCofig {
}