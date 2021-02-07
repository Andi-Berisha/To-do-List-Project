package com.qa.starterprojects.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class HouseDomain {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String address;
	
	@OneToMany(mappedBy = "myHouse", fetch=FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<CatDomain> catList;

	
	public HouseDomain() {
		super();
	}

	

	public HouseDomain(Long id, String address, List<CatDomain> catList) {
		super();
		this.id = id;
		this.address = address;
		this.catList = catList;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public List<CatDomain> getCatList() {
		return catList;
	}



	public void setCatList(List<CatDomain> catList) {
		this.catList = catList;
	}



	
}
