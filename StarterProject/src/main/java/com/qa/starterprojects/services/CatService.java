package com.qa.starterprojects.services;

import java.util.List;



import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.qa.starterprojects.persistence.domain.CatDomain;
import com.qa.starterprojects.persistence.dtos.CatDTO;

import com.qa.starterprojects.persistence.repos.CatRepo;

@Service
public class CatService {
	
	private CatRepo repo;
	private ModelMapper mapper;
  
	@Autowired
	public CatService(CatRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private CatDTO mapToDTO (CatDomain model) {
		return this.mapper.map(model, CatDTO.class);
	}
	//read One
//	public CatDTO readOne(Long id) {
//		this.repo.findById(Long id)
//	}
	
	
	//create
	
		
		public CatDTO create(CatDomain cat){
			
			return this.mapToDTO(this.repo.save(cat));
		}

	//read
		public List<CatDTO> readAll(){
		List <CatDomain> dbList = this.repo.findAll();
		List <CatDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		
		return resultList;
		}
		
	// Update
		public CatDTO update(Long id, CatDomain newDetails) {
			 this.repo.findById(id).orElseThrow();
			 
			 // cat target
			 newDetails.setId(id);
			 
		     return mapToDTO(this.repo.save(newDetails));
		     }
	// Delete
		public boolean delete(Long id) {
			this.repo.deleteById(id);
			return !this.repo.existsById(id);
		}

		public CatDTO readOne(long l) {
			// TODO Auto-generated method stub
			return null;
		}
		
	
	
	
	

}
