package com.demo.mongodb.data;

import java.text.DecimalFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PRODUCT")
public class Product {

	@Id
	public String id;
	public String name;
	public String price;
	
	public Product() {}

    public Product(String id, String name, String price) {
    	this.id = id;
        this.name= name;
        this.price = price;
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
    public String toString() {
        return "Product {" +
        		" id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Price=" + price +
                '}';
	}
}
