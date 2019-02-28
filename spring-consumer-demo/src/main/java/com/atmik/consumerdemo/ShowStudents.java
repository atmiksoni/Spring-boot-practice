package com.atmik.consumerdemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableAutoConfiguration
public class ShowStudents {

	
	@GetMapping(value="/showAll",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  Student showStudents() {
		
		RestTemplate restTemplate = new RestTemplate();
		String uri= "http://localhost:8083/searchStudent/find/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
		ResponseEntity<Student> response = restTemplate.getForObject(uri, ResponseEntity.class, params);
		
		return  response.getBody();
		
	}
}
