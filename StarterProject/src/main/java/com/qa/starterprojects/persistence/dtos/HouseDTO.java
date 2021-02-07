package com.qa.starterprojects.persistence.dtos;

import java.util.List;



public class HouseDTO {
	
	
    private Long id;
	
	private String address;
	private List<CatDTO> catList;

	public HouseDTO() {
		super();
	}

	public HouseDTO(Long id, String address, List<CatDTO> catList) {
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

	public List<CatDTO> getCatList() {
		return catList;
	}

	public void setCatList(List<CatDTO> catList) {
		this.catList = catList;
	}

}

