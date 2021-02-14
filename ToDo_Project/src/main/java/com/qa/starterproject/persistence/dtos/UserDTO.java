package com.qa.starterproject.persistence.dtos;

import java.util.List;




public class UserDTO {

	private Long id;

	private String user_name;

	private String user_surname;


	private List<TaskDTO> tasks;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, String user_name, String user_surname, List<TaskDTO> tasks) {
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

	public List<TaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDTO> tasks) {
		this.tasks = tasks;
	}


}
