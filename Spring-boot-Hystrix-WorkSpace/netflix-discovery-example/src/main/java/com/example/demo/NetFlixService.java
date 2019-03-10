package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetFlixService {
	
	@GetMapping("/")
	public String welComeCommand() {
		return "Welcome to Netflix Service";
	}

}
