package com.atmik.springdemo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atmik.springdemo.entity.Student;
import com.atmik.springdemo.entity.StudentRepository;

@RestController
@EnableAutoConfiguration
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/searchStudent/find")
	public @ResponseBody Student getStudent(@RequestParam Long id ) {
		Optional optional=  studentRepository.findById(id);
		return (Student) optional.get();
	}
	

	@PostMapping(path="/createStudent/",consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = "application/json" )
	public  @ResponseBody Student createStudent(@RequestBody Student student ) {		
		return studentRepository.save(student);
		
	}
	
	
	
	@RequestMapping(value="/searchStudent")
	public String helloStudent() {
		return "Hello Student";
	}
	
}
