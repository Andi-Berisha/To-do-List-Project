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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((User == null) ? 0 : User.hashCode());
		result = prime * result + ((hasTaskBeenCompletedCheck == null) ? 0 : hasTaskBeenCompletedCheck.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((task_name == null) ? 0 : task_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDomain other = (TaskDomain) obj;
		if (User == null) {
			if (other.User != null)
				return false;
		} else if (!User.equals(other.User))
			return false;
		if (hasTaskBeenCompletedCheck == null) {
			if (other.hasTaskBeenCompletedCheck != null)
				return false;
		} else if (!hasTaskBeenCompletedCheck.equals(other.hasTaskBeenCompletedCheck))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (task_name == null) {
			if (other.task_name != null)
				return false;
		} else if (!task_name.equals(other.task_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaskDomain [id=" + id + ", task_name=" + task_name + ", hasTaskBeenCompletedCheck="
				+ hasTaskBeenCompletedCheck + ", User=" + User + "]";
	}
	
	

	

}
