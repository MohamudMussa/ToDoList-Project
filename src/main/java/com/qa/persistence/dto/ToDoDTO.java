package com.qa.persistence.dto;



import java.util.List;



public class ToDoDTO {
	
	private Long id;
	private String address;
	private List<TaskDTO> catList;
	
	public ToDoDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<TaskDTO> getCatList() {
		return catList;
	}

	public void setCatList(List<TaskDTO> catList) {
		this.catList = catList;
	}

	@Override
	public String toString() {
		return "ToDoDTO [id=" + id + ", address=" + address + ", catList=" + catList + "]";
	}




}
