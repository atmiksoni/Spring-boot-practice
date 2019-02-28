package com.netflix.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringNetflixEurekaCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNetflixEurekaCloudApplication.class, args);
	}

}
