package com.demo;

import java.net.InetAddress;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mongodb.bl.MyService;
import com.demo.mongodb.data.Product;


@RestController
@SuppressWarnings("deprecation")
public class HelloController {

	@Autowired
	private MyService myservice;
	
	@RequestMapping("/dummy")
	public String getDummy() 
	{
		return "DUMMY REQ";
	}

	@RequestMapping("/demo")
	public String getDemo() 
	{
		return myservice.getResponse("message").toString();
	}
	
	@RequestMapping("/product")
	public String getProduct() {
		
		return "Use product/get or product/create";
	}

	@RequestMapping("/product/get/id/{id}")
	public String getProductById(@PathVariable String id) {
		
		Product p = myservice.getProductById(id);
		return p == null ? "NO PRODUCT FOUND " : p.toString() +"{host: "+getHostName()+"}";
	}
	
	@RequestMapping("/product/get/name/{name}")
	public String getProductByName(@PathVariable String name) {
		
		Product p = myservice.getProductByName(name);
		return p == null ? "NO PRODUCT FOUND " : p.toString();
	}

	@RequestMapping("/product/get/price/{price}")
	public String getProductByPrice(@PathVariable String price) {
		
		Product p = myservice.getProductByPrice(price);
		return p == null ? "NO PRODUCT FOUND " : p.toString();
	}


	@PostMapping("/product/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
		myservice.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@PostMapping("/product/create/bulk")
    public ResponseEntity<String> createProductsInBulk(@RequestBody Product[] products){
		for (Product product : products)
		{
			myservice.createProduct(product);
		}
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	
	@RequestMapping("/hello")
	public String welcome(Map<String, Object> model) {
		model.put("serverName", this.getHostName());
		model.put("time", (new Date()).toGMTString());
		return "hello";
	}
	
	public String getHostName() {
		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    return addr.getHostName();
		}
		catch (Exception ex)
		{
		    System.out.println("Hostname can not be resolved");
		}
		return "";		
	}
}