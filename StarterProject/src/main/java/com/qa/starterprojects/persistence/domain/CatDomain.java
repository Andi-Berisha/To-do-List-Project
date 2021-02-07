package com.qa.starterprojects.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CatDomain {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column (nullable =false)
private String name;

@Column
private Integer age;

@Column
private Long weight;

@ManyToOne
private HouseDomain myHouse;

public CatDomain() {
	super();
}



public CatDomain(Long id) {
	super();
	this.id = id;
}



public CatDomain(Long id, String name, Integer age, Long weight, HouseDomain myHouse) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.weight = weight;
	this.myHouse = myHouse;
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public Integer getAge() {
	return age;
}



public void setAge(Integer age) {
	this.age = age;
}



public Long getWeight() {
	return weight;
}



public void setWeight(Long weight) {
	this.weight = weight;
}



public HouseDomain getMyHouse() {
	return myHouse;
}



public void setMyHouse(HouseDomain myHouse) {
	this.myHouse = myHouse;
}


}





