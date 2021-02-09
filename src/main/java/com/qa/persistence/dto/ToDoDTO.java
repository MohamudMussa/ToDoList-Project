package com.qa.persistence.dto;



import java.util.List;



public class ToDoDTO {
	
	private Long id;
	private String listName;
//	private List<TaskDTO> taskList;
	
	public ToDoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDoDTO(Long id, String listName, List<TaskDTO> taskList) {
		super();
		this.id = id;
		this.listName = listName;
//		this.taskList = taskList;
	}

	
	public ToDoDTO(Long id, String listName) {
		super();
		this.id = id;
		this.listName = listName;

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getlistName() {
		return listName;
	}

	public void setlistName(String listName) {
		this.listName = listName;
	}

//	public List<TaskDTO> getTaskList() {
//		return taskList;
//	}
//
//	public void setTaskList(List<TaskDTO> taskList) {
//		this.taskList = taskList;
//	}





}
