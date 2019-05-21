package com.example.SpringBootMongoDb.demo.springbootMongoDb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootMongoDb.demo.springbootMongoDb.Service.ProductService;
import com.example.SpringBootMongoDb.demo.springbootMongoDb.model.Order;

@RestController
public class ProductController {
     @Autowired
	private ProductService productService;
     @RequestMapping("/create")
     public String create(@RequestParam String name, @RequestParam String summary, @RequestParam int price) {
    Order p =productService.create(name, summary, price);
    return p.toString();
     }
     @RequestMapping("/get")
     public Order getCustomer(@RequestParam String name) {
    	 return productService.getByName(name);
     }
     @RequestMapping("/getAll")
     public List<Order> getAll(){
    	 return productService.getAll();
     }
     @RequestMapping("/update")
     public String update(@RequestParam String name, @RequestParam String summary, @RequestParam int price) {
    	    Order p =productService.create(name, summary, price);
    	    return p.toString();
    	     }
     @RequestMapping("/delete")
     public String delete(@RequestParam String name) {
    	 productService.delete(name);
    	 return "Deleted" + name;
     }
     @RequestMapping("/deleteAll")
     public String deleteAll() {
    	 productService.deleteAll();
    	 return "Deleted All records";
     }
}

