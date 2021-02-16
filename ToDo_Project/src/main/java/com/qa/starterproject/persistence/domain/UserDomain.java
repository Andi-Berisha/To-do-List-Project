package com.qa.starterproject.persistence.domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

	@Entity
	public class UserDomain {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column
		private String user_name;
		
		@Column
		private String user_surname;
		
		
		
		@OneToMany(mappedBy = "User", fetch = FetchType.EAGER)
		@OnDelete(action = OnDeleteAction.CASCADE)
		private List<TaskDomain> tasks;

		public UserDomain() {
			super();
		}

		public UserDomain(Long id, String user_name, String user_surname,
				List<TaskDomain> tasks) {
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

 
