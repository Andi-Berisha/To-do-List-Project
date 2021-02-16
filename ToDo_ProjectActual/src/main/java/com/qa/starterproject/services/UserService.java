package com.qa.starterproject.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.starterproject.persistence.domain.UserDomain;
import com.qa.starterproject.persistence.dtos.UserDTO;
import com.qa.starterproject.persistence.repos.UserRepo;

@Service
public class UserService {

	private UserRepo repo;
	private ModelMapper mapper;

	@Autowired
	public UserService(UserRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private UserDTO maptoDTO(UserDomain model) {
		return this.mapper.map(model, UserDTO.class);
	}

	// create

	public UserDTO create(UserDomain model) {

		return this.maptoDTO(this.repo.save(model));
	}
	
	//read one
	
	public UserDTO readById(Long id) {
		return this.maptoDTO(this.repo.findById(id).orElseThrow());
		
	}


	// readAll
public List<UserDTO> readAll(){
		
		List<UserDomain> dbList = this.repo.findAll();
		
		List<UserDTO> resultList = dbList.stream().map(this::maptoDTO).collect(Collectors.toList());
		return resultList;
}
	

	// Update
	public UserDTO update(Long id, UserDomain model) {
		this.repo.findById(id).orElseThrow();

		// cat target
		model.setId(id);

		return maptoDTO(this.repo.save(model));
	}

	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
