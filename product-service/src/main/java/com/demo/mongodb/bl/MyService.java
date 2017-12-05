package com.demo.mongodb.bl;

import com.demo.mongodb.api.response.ServiceResponse;
import com.demo.mongodb.data.Product;

public interface MyService {
    ServiceResponse getResponse(String key);
    Product getProductById(String id);
    Product getProductByName(String name);
    Product getProductByPrice(String price);
    Product createProduct(Product product);
}
