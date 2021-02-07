package com.qa.starterprojects.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.qa.starterprojects.persistence.domain.HouseDomain;

@Repository
public interface HouseRepo extends JpaRepository <HouseDomain, Long> {

	// CRUD -> h2 Database
	
	//.save
	
	//find/findall
	

}
