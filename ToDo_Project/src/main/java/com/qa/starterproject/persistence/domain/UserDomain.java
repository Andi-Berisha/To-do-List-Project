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
		
		@Column String user_password;
		
		@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
		@OnDelete(action = OnDeleteAction.CASCADE)
		private List<TaskDomain> tasks;

		public UserDomain() {
			super();
		}

		public UserDomain(Long id, String user_name, String user_surname, String user_password,
				List<TaskDomain> tasks) {
			super();
			this.id = id;
			this.user_name = user_name;
			this.user_surname = user_surname;
			this.user_password = user_password;
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

		public String getUser_password() {
			return user_password;
		}

		public void setUser_password(String user_password) {
			this.user_password = user_password;
		}

		public List<TaskDomain> getTasks() {
			return tasks;
		}

		public void setTasks(List<TaskDomain> tasks) {
			this.tasks = tasks;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
			result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
			result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
			result = prime * result + ((user_surname == null) ? 0 : user_surname.hashCode());
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
			UserDomain other = (UserDomain) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (tasks == null) {
				if (other.tasks != null)
					return false;
			} else if (!tasks.equals(other.tasks))
				return false;
			if (user_name == null) {
				if (other.user_name != null)
					return false;
			} else if (!user_name.equals(other.user_name))
				return false;
			if (user_password == null) {
				if (other.user_password != null)
					return false;
			} else if (!user_password.equals(other.user_password))
				return false;
			if (user_surname == null) {
				if (other.user_surname != null)
					return false;
			} else if (!user_surname.equals(other.user_surname))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "UserDomain [id=" + id + ", user_name=" + user_name + ", user_surname=" + user_surname
					+ ", user_password=" + user_password + ", tasks=" + tasks + "]";
		}
		
		
		
		
		
		
		
		

	}

 
