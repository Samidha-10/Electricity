package com.cg.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.consumer.entity.Consumer;
import com.cg.consumer.exceptions.ConsumerException;
import com.cg.consumer.service.ConsumerService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
@Slf4j
public class ConsumerController {
	@Autowired
	ConsumerService consumerService;
	
	@GetMapping("/consumer")
	public List<Consumer> getAllConsumer(){
		log.info("entering into get method in controller");
		List<Consumer> consumer = consumerService.getAllConsumer();
		System.out.println("list of consumers" + consumer);
		log.info("exiting from get method in controller");
		return consumer;
		
	}
	
	@GetMapping("/consumer/{id}")
	public ResponseEntity<Object> getConsumer(@PathVariable long id) throws ConsumerException{
		Consumer consumer;
		//Cart resultCart;
		log.info("entering into getById method in controller");
        try {
        	consumer = consumerService.getConsumer(id);
        	System.out.println(consumer);
        	log.info("exiting from getById method in controller");
            return new ResponseEntity<Object>(consumer, HttpStatus.OK);
            
        } catch (ConsumerException e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
            
        }
		
		
	}
	@Validated
	@PostMapping("/consumer")
	public Consumer saveConsumer(@RequestBody @Valid Consumer consumer) {
		log.info("entering into add method in controller");
		Consumer consumerdto = consumerService.saveConsumer(consumer);
		System.out.println(consumerdto);
		log.info("exiting from add method in controller");
		return consumerdto;
	}
	
	@PutMapping("/consumer/{id}")
	public ResponseEntity<Object> updateConsumer(@RequestBody Consumer consumer) {
		Consumer consumerdto;
		log.info("entering into update method in controller");
		try {
			consumerdto = consumerService.updateConsumer(consumer);
			System.out.println(consumerdto);
			log.info("exiting from update method in controller");
            return new ResponseEntity<Object>(consumerdto, HttpStatus.OK);
            
        } catch (ConsumerException e) {
        	
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
	}
	
	@DeleteMapping("/consumer/{id}")
	public String deleteConsumer(@PathVariable long id) {
		log.info("entering into delete method in controller");
		consumerService.deleteConsumer(id);
		log.info("exiting from delete method in controller");
		return "Successfully Deleted consumer";
		
	}
	

}
