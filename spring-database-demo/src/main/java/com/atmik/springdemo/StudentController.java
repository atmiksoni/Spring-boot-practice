package com.atmik.springdemo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atmik.springdemo.entity.Student;
import com.atmik.springdemo.entity.StudentRepository;

@RestController(value="/")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping(value="/searchStudent/{studentId}")
	public @ResponseBody Student getStudent(@RequestParam Integer studentId ) {
		Optional optional=  studentRepository.findById(studentId);
		return (Student) optional.get();
	}
	
	
	@RequestMapping(value="/searchStudent")
	public String helloStudent() {
		return "Hello Student";
	}
	
}
