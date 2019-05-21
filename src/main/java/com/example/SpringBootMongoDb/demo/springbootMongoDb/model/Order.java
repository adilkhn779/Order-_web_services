package com.example.SpringBootMongoDb.demo.springbootMongoDb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
 @Id
 int id;
 int customerId;
 int productId;

 
 public Order(int id, int customerId, int productId) {
	 this.id=id;
	this.customerId=customerId;
	this.productId=productId;
 }


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSummary() {
	return summary;
}

public void setSummary(String summary) {
	this.summary = summary;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}


@Override
public String toString() {
	return "Customer [  Name=" + name + ", Summary=" + summary + ", Price=" + price + "]";
}
 

}
