package com.example.SpringBootMongoDb.demo.springbootMongoDb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootMongoDb.demo.springbootMongoDb.model.Order;
import com.example.SpringBootMongoDb.demo.springbootMongoDb.repository.ProductRepository;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

//@GraphQLApi is to impose this service for GraphQL
@Service
@GraphQLApi
public class ProductGraphQlService {

	@Autowired
	private ProductRepository productRepository;

	@GraphQLQuery
	public List<Order> findAllProduct() {
		return productRepository.findAll();
	}

	@GraphQLMutation(name = "createProduct")
	public Order saveProduct(String id, String name, String summary, int price) {
		return productRepository.save(new Order(name, summary, price));
	}

	@GraphQLMutation(name = "updateProduct")
	public Order updateCustomer(String name, String summary, int price) {
		Order product = findProductByName(name);
		product.setSummary(summary);
		product.setPrice(price);
		return productRepository.save(product);
	}

	@GraphQLQuery(name = "product")
	public Order findProductByName(String name) {
		Order p = productRepository.findByName(name);
		return p;
	}

	@GraphQLQuery(name = "product")
	public Order findOrderById(String id) {
		Optional<Order> p = productRepository.findById(id);
		if (!p.isPresent())
			throw new RuntimeException("product doesn't exist with given id " + id);
		return p.get();
	}

	@GraphQLMutation(name = "deleteProduct")
	public String deleteProduct(String name) {
		Order p = productRepository.findByName(name);
		productRepository.delete(p);
		return "Customer deleted Successfully";

	}

	@GraphQLMutation(name = "deleteProduct")
	public String deleteAllProduct() {
		productRepository.deleteAll();
		return "Deleted Successfully";
	}

}
