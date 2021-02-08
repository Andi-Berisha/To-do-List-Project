package com.qa.starterproject.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.starterproject.persistence.domain.TaskDomain;


@Repository
public interface TaskRepo extends JpaRepository <TaskDomain, Long> {

	// CRUD -> h2 Database
	
	//.save
	
	//find/findall
	

}
