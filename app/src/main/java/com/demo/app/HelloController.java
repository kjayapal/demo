package com.demo.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

@RefreshScope
@RestController
public class HelloController {

	@Value("${message:Hello default...}")
    private String message;
	
	@Lazy
	@Autowired
    RestTemplate restTemplate;

//	@Autowired
//	private DiscoveryClient discoveryClient;
	
	
	@RequestMapping ("/")
	public String sayHello()
	{
		return this.message;
	}
	
//	@RequestMapping("/service-instances/{applicationName}")
//    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
//        return this.discoveryClient.getInstances(applicationName);
//    }
	
	@RequestMapping("/call/{applicationName}/{methodName}")
    public String serviceInstances(@PathVariable String applicationName, @PathVariable String methodName) {

		
//		StringBuffer sb = new StringBuffer();
		
		String response = restTemplate.exchange("http://demo-service/demo", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, methodName).getBody();
		
		
//		sb.append("Services: \n");
//		for (ServiceInstance si : this.discoveryClient.getInstances(applicationName)) {
//			sb.append(si.getServiceId() +"\n");
//			
//		}
		
		return response;
    }
	
//	@LoadBalanced
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	
}
