package com.qa.starterprojects.rest;


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

import com.qa.starterprojects.persistence.domain.HouseDomain;
import com.qa.starterprojects.persistence.dtos.HouseDTO;
import com.qa.starterprojects.services.HouseService;


@RestController
@RequestMapping("/house")
public class HouseController {
	
	private HouseService service;
	
	@Autowired
	public HouseController(HouseService service) {
		super();
		this.service = service;
	}

	
	
//create complete
	
	@PostMapping("/create")
	public ResponseEntity<HouseDTO> create(@RequestBody HouseDomain model){
		return new ResponseEntity<HouseDTO>(this.service.create(model),HttpStatus.CREATED);
		
	}
//read one
//	public ResponseEntity <CatDTO> readCat
	
//read
	@GetMapping("/readAll")
	public ResponseEntity<List<HouseDTO>> readAll(){
		return ResponseEntity.ok(this.service.readAll());
	}
	
// Update
	@PutMapping("/update")
	public ResponseEntity<HouseDTO> update(@PathVariable("id") Long id, @RequestBody HouseDomain model) {
		return new ResponseEntity<HouseDTO>(this.service.update(id, model),HttpStatus.ACCEPTED);
		
	}
	
// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT):
			    new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	

}
