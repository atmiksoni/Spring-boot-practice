package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class SimpleHysterixExample {

	
	@RequestMapping("/hysterix-example")
	@HystrixCommand(fallbackMethod="service_down", commandProperties ={
		@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" ,value="1000")
	})
	public String thirdPartyService() throws InterruptedException {
		Thread.sleep(3000);
		
		return "Welcome to thirdParty Service";
		
	}
	
	
	private String service_down() {
		return "Request fails. It takes long time to response";
	}
	
	@Autowired
	EurekaClient eurekaClient;
	
	@HystrixCommand(fallbackMethod="service_down")
	@GetMapping("/simple-app")
	public String callingNetflixService() {
		//InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("netflix-service", false);
       // String serviceBaseUrl = instanceInfo.getHomePageUrl();
		RestTemplate restTemplate =  new RestTemplate();
		String serviceBaseUrl= "http://localhost:8085";
		
		ResponseEntity<String> responseEntity =  restTemplate.getForEntity(serviceBaseUrl, String.class);
		return responseEntity.getBody();
		
	}
}

 
