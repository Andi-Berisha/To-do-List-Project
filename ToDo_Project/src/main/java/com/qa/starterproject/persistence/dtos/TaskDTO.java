package com.qa.starterproject.persistence.dtos;

import com.qa.starterproject.persistence.domain.UserDomain;

public class TaskDTO {
	
	
	private Long id;
	

	private String task_name;
	
	
	private Boolean hasTaskBeenCompletedCheck;
	
	
	private UserDomain User;


	public TaskDTO() {
		super();
	}


	public TaskDTO(Long id, String task_name, Boolean hasTaskBeenCompletedCheck, UserDomain user) {
		super();
		this.id = id;
		this.task_name = task_name;
		this.hasTaskBeenCompletedCheck = hasTaskBeenCompletedCheck;
		User = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTask_name() {
		return task_name;
	}


	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}


	public Boolean getHasTaskBeenCompletedCheck() {
		return hasTaskBeenCompletedCheck;
	}


	public void setHasTaskBeenCompletedCheck(Boolean hasTaskBeenCompletedCheck) {
		this.hasTaskBeenCompletedCheck = hasTaskBeenCompletedCheck;
	}


	public UserDomain getUser() {
		return User;
	}


	public void setUser(UserDomain user) {
		User = user;
	}


	
	
}
