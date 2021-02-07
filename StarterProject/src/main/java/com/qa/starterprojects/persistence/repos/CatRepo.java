package com.qa.starterprojects.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.starterprojects.persistence.domain.CatDomain;

@Repository
public interface CatRepo extends JpaRepository <CatDomain, Long> {

	// CRUD -> h2 Database
	
	//.save
	
	//find/findall
	

}
