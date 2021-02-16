package com.qa.starterproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.starterproject.persistence.domain.UserDomain;
import com.qa.starterproject.persistence.dtos.UserDTO;
import com.qa.starterproject.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	private UserService service;

	@Autowired
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	
	//create
	
		@PostMapping("/create")
		public ResponseEntity<UserDTO> create(@RequestBody UserDomain user){
			return new ResponseEntity<UserDTO>(this.service.create(user),HttpStatus.CREATED);
			
	}
	//read one

		@GetMapping("/read/{id}")
		public ResponseEntity<UserDTO> readByToDoId(@PathVariable("id") Long id){
			return ResponseEntity.ok(this.service.readById(id));
		}
		
		
		
	//readAll
		@GetMapping("/readAll")
		public ResponseEntity<List<UserDTO>> readAll(){
			return ResponseEntity.ok(this.service.readAll());
		}
		
	// Update
		@PutMapping("/update/{id}")
		public ResponseEntity<UserDTO> update(@PathVariable("id") Long id, @RequestBody UserDomain user) {
			return new ResponseEntity<UserDTO>(this.service.update(id, user),HttpStatus.ACCEPTED);
			
		}
		
	// Delete
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
			return this.service.delete(id) ? 
					new ResponseEntity<>(HttpStatus.NO_CONTENT):
				    new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		

	}
	
	
	
	
	
	
	
	


