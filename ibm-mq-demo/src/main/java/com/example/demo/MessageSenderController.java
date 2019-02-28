package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableJms
public class MessageSenderController {
	
	@Autowired
	JmsTemplate jmsTemplate;

	
	@PostMapping(value="/send", produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String SendMessage(@RequestBody String msg) {
		try{
			System.out.println("MSG recieved::"+msg);
			
	        jmsTemplate.convertAndSend("FROM_DLM_TO_MATCHING_188_1", msg);
	        return "OK";
	    }catch(JmsException ex){
	        ex.printStackTrace();
	        return "FAIL";
	    }
	}
}
