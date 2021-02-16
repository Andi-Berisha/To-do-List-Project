package com.qa.starterproject.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TaskDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String task_name;
	
	@NotNull
	private Boolean hasTaskBeenCompletedCheck;
	
	@ManyToOne
	private UserDomain User;

	public TaskDomain() {
		super();
	}

	public TaskDomain(Long id, @NotNull String task_name, @NotNull Boolean hasTaskBeenCompletedCheck, UserDomain user) {
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
