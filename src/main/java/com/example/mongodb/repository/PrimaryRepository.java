package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb.domain.Product;


public interface PrimaryRepository extends MongoRepository<Product, String> {
}