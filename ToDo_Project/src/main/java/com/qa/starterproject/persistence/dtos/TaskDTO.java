package com.qa.starterproject.persistence.dtos;


public class TaskDTO {
	
	
	private Long id;
	

	private String task_name;
	
	
	private Boolean hasTaskBeenCompletedCheck;
	
	
//	private UserDomain User; protected to prevent recursive issue.


	public TaskDTO() {
		super();
	}


public TaskDTO(Long id, String task_name, Boolean hasTaskBeenCompletedCheck) {
	super();
	this.id = id;
	this.task_name = task_name;
	this.hasTaskBeenCompletedCheck = hasTaskBeenCompletedCheck;
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


}
