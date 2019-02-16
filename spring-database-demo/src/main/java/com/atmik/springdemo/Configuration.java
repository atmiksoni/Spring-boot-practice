package com.atmik.springdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring-demo")
public class Configuration {
	
	private String studentNotFound;

	public String getStudentNotFound() {
		return studentNotFound;
	}

	public void setStudentNotFound(String studentNotFound) {
		this.studentNotFound = studentNotFound;
	}
	
	

}
