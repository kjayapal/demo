package com.demo.mongodb.bl.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.mongodb.api.response.ServiceResponse;
import com.demo.mongodb.bl.MyService;
import com.demo.mongodb.config.MyConfigurationProperties;
import com.demo.mongodb.data.Product;
import com.demo.mongodb.data.ProductRepository;

@Service(value = "MyService")
@EnableConfigurationProperties(MyConfigurationProperties.class)
public class MyServiceImpl implements MyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServiceImpl.class);

    @Autowired
    private MyConfigurationProperties myConfigurationProperties;
    
	@Autowired
	private ProductRepository productRepo;


    @Value("${message: Default from service}")
    private String message;

//    @Override
//    @Timed
//    @ExceptionMetered
//    @HystrixCommand(groupKey = "hystrixGroup",
//            commandKey = "helloCommandKey",
//            threadPoolKey = "helloThreadPoolKey",
//            fallbackMethod = "fallbackHello")
    @Cacheable(cacheNames = "default")
    
//    @LogExecutionTime
    public ServiceResponse getResponse(String key) {
        LOGGER.info("getResponse called ");
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage(key);
//        serviceResponse.setType("valid");
        return serviceResponse;
    }
    
    public Product getProductById(String id) {
        LOGGER.info("getProductByID called ");
        return productRepo.findById(id);
    }

    public Product getProductByName(String name) {
        LOGGER.info("getProductByName called ");
        return productRepo.findByName(name);
    }

    public Product getProductByPrice(String price) {
        LOGGER.info("getProductByName called ");
        return productRepo.findByName(price);
    }

    public Product createProduct(Product product) {
        LOGGER.info("createProduct called ");
        return productRepo.save(product);
    }

    public ServiceResponse fallbackHello(String name) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setMessage("This is Hello fromm fallback " + name);
        return serviceResponse;
    }


}
