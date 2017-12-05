package com.demo.mongodb.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {

	public Product findById(String id);
    public Product findByName(String name);
//    public List<Product> findByPrice(float price);

}
