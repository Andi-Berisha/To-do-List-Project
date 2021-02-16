package com.qa.starterproject.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.starterproject.persistence.domain.TaskDomain;
import com.qa.starterproject.persistence.dtos.TaskDTO;
import com.qa.starterproject.persistence.repos.TaskRepo;

@Service
public class TaskService {

	private TaskRepo repo;
	private ModelMapper mapper;

	@Autowired
	public TaskService(TaskRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private TaskDTO mapToDTO(TaskDomain task) {
		return this.mapper.map(task, TaskDTO.class);
	}

	// read One (get)

	public TaskDTO readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());}

	// create (post)
	public TaskDTO create(TaskDomain task) {

		return this.mapToDTO(this.repo.save(task));
	}

	// readAll (get)
	public List<TaskDTO> readAll() {
		List<TaskDomain> dbList = this.repo.findAll();
		List<TaskDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;
	}

	// Update
	public TaskDTO update(Long id, TaskDomain newDetails) {
		this.repo.findById(id).orElseThrow();

		// task target
		newDetails.setId(id);

		return mapToDTO(this.repo.save(newDetails));
	}

	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
