package com.qa.persistence.dto;


public class TaskDTO {

	private Long id;
	private String name;
	private String category;
	private Integer rank;
	private Boolean completed;
	private ToDoDTO myHouse;

	public TaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//remove what you want to protect it from being exposed
	public TaskDTO(Long id, String name, String category, Integer rank, Boolean completed) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.rank = rank;
		this.completed = completed;
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

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Integer getRank() {
		return rank;
	}


	public void setRank(Integer rank) {
		this.rank = rank;
	}


	public ToDoDTO getMyHouse() {
		return myHouse;
	}


	public void setMyHouse(ToDoDTO myHouse) {
		this.myHouse = myHouse;
	}

}
