package com.qa.starterproject.persistence.dtos;


public class TaskDTO {
	
	
//	private Long id; protected as it is unnecessary data.
	

	private String task_name;
	
	
	private Boolean hasTaskBeenCompletedCheck;
	
	
//	private UserDomain User; protected to prevent recursive issue.


	public TaskDTO() {
		super();
	}


public TaskDTO(String task_name, Boolean hasTaskBeenCompletedCheck) {
	super();
	
	this.task_name = task_name;
	this.hasTaskBeenCompletedCheck = hasTaskBeenCompletedCheck;
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
