package com.atmik.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = StudentController.class,value= {"com.atmik.springdemo.entity"})
public class SpringDatabaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseDemoApplication.class, args);
	}

}

