package com.example.SpringBootMongoDb.demo.springbootMongoDb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootMongoDb.demo.springbootMongoDb.model.Order;

@Repository
public interface ProductRepository extends MongoRepository<Order, String> {
 public Order findByName(String name);
 public List<Order> findByPrice(int price);
}
