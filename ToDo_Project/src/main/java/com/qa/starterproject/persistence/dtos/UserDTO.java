package com.qa.starterproject.persistence.dtos;

import java.util.List;

import com.qa.starterproject.persistence.domain.TaskDomain;

public class UserDTO {

	private Long id;

	private String user_name;

	private String user_surname;

//	private String user_password; protected value

	private List<TaskDomain> tasks;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String user_name, String user_surname, List<TaskDomain> tasks) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_surname = user_surname;
		this.tasks = tasks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_surname() {
		return user_surname;
	}

	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}

	public List<TaskDomain> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDomain> tasks) {
		this.tasks = tasks;
	}

}
