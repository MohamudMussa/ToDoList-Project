package com.qa.persistence.dto;



import java.util.List;



public class ToDoDTO {
	
	private Long id;
	private String category;
//	private List<TaskDTO> taskList;
	
	public ToDoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDoDTO(Long id, String category, List<TaskDTO> taskList) {
		super();
		this.id = id;
		this.category = category;
//		this.taskList = taskList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	public List<TaskDTO> getTaskList() {
//		return taskList;
//	}
//
//	public void setTaskList(List<TaskDTO> taskList) {
//		this.taskList = taskList;
//	}





}
