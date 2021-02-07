package com.qa.starterprojects.persistence.dtos;

public class CatDTO {

	private Long id;

	private String name;

	private Integer age; // protecting this variable

	private Long weight;

	public CatDTO() {
		super();
	}

	public CatDTO(Long id, String name, Long weight) {
		super();
		this.id = id;
		this.name = name;

		this.weight = weight;
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

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

}
