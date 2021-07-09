package com.qa.spring.golfers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.spring.golfers.domain.Players;
import com.qa.spring.golfers.service.GolferService;


// we need to add a @RestController - this handles requests and provides a reponse
// hover over the words and import from javax
@RestController
@RequestMapping("/player") // this will 'map' the path to http://localhost:9092/golf/.....
 

//  start the main method code from here

public class GolferController {
	
//	First we need to add the Dependency on the Service Class
	
//	Dependency
	private GolferService service;
	
	
//	This connects the Controller and the Service
	@Autowired
	public GolferController(GolferService service) {
		this.service =service;	
	}
	
	
//	Now add the @GetMapping elements - first do a test map
//	hover over @getMapping and import from javax
	@GetMapping("/test")
	public String test() {
	return "This is a test to read the players"; 
	}
	
	
//	CRUD - Create, Read, Update, Delete
	
//	Create first - needs to use @PostMapping and specify the 
//	added http element
	@PostMapping("/createplayer")
	public ResponseEntity<Players> create(@RequestBody Players player) {
		return new ResponseEntity<Players>(this.service.create(player), HttpStatus.CREATED);
	
	}
	
	
//	READ - use @GetMapping and specify http element
	
	@GetMapping("/read")
	public ResponseEntity<List<Players>> read(){
		return new ResponseEntity<List<Players>>( this.service.read(), HttpStatus.OK);
	}
		
	// U: Update
		@PutMapping("/replace/{id}")
		public ResponseEntity<Players> update(@PathVariable Long id, @RequestBody Players player){
			return new ResponseEntity<Players>( this.service.update(id, player), HttpStatus.ACCEPTED);
		}
		
		// D: Delete
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Boolean> delete(@PathVariable Long id){
			return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
		}
	
	
	
	
		
	}
	
	
	

