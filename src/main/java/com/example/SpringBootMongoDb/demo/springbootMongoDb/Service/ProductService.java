package com.example.SpringBootMongoDb.demo.springbootMongoDb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootMongoDb.demo.springbootMongoDb.model.Order;
import com.example.SpringBootMongoDb.demo.springbootMongoDb.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
	private ProductRepository productRepository;
    
    //create Operation
    public Order create(String name, String summary, int price) {
    	return productRepository.save(new Order(name,summary,price));
    }
    
    //retrieve operation
    public List<Order> getAll(){
    	return productRepository.findAll();
    }
    public Order getByName( String name) {
    	return productRepository.findByName(name);
    }
    //update operation
    public Order update(String name, String summary, int price) {
    	Order p = productRepository.findByName(name);
    	p.setSummary(summary);
    	p.setPrice(price);
    	return productRepository.save(p);
    }
    //delete operation
    public void deleteAll() {
    	productRepository.deleteAll();
    }
    public void delete(String name) {
    	Order p =productRepository.findByName(name);
    	productRepository.delete(p);
    }
}
