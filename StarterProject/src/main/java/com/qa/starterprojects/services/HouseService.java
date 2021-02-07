package com.qa.starterprojects.services;

import java.util.List;

import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.starterprojects.persistence.domain.HouseDomain;
import com.qa.starterprojects.persistence.dtos.HouseDTO;

import com.qa.starterprojects.persistence.repos.HouseRepo;

@Service
public class HouseService {
	
	private HouseRepo repo;
	private ModelMapper mapper;
  
	@Autowired
	public HouseService(HouseRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private HouseDTO mapToDTO (HouseDomain model) {
		return this.mapper.map(model, HouseDTO.class);
	}
	//read One
//	public CatDTO readOne(Long id) {
//		this.repo.findById(Long id)
//	}
	
	
	//create
	
		
		public HouseDTO create(HouseDomain model){
			
			return this.mapToDTO(this.repo.save(model));
		}

	//read
		public List<HouseDTO> readAll(){
		List<HouseDomain> houselist = this.repo.findAll();
		List <HouseDTO> 	HouseList = houselist.stream().map(this::mapToDTO).collect(Collectors.toList());
		
		return HouseList;
		}
		
	// Update
		public HouseDTO update(Long id, HouseDomain model) {
			 this.repo.findById(id).orElseThrow();
			 
			 // cat target
			 model.setId(id);
			 
		     return mapToDTO(this.repo.save(model));
		     }
	// Delete
		public boolean delete(Long id) {
			this.repo.deleteById(id);
			return !this.repo.existsById(id);
		}
		
	
	
	
	

}
