package com.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.entity.Product;

public interface Product_Repository extends ReactiveMongoRepository<Product, String> {

}
