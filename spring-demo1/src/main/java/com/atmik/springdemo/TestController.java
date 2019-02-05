package com.atmik.springdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/")
public class TestController {
	
	
	@RequestMapping(value="/hello")
	public String helloWorld() {
		System.out.println("Spring boot first application");
		return "welcome tp spring application";
	}

}
