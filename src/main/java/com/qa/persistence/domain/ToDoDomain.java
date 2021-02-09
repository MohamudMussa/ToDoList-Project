package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.sun.istack.NotNull;

@Entity
public class ToDoDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	public Long id;

	private String category;


	// one to many annotation
	@OneToMany(mappedBy = "myToDo", fetch = FetchType.EAGER)

	// this will remove objects along side their foreign key
	@OnDelete(action = OnDeleteAction.CASCADE)


	private List<TaskDomain> taskList;
	
	


	public ToDoDomain() {
		super();
		// TODO Auto-generated constructor stub
	}




	public ToDoDomain(Long id, String category, List<TaskDomain> taskList) {
		super();
		this.id = id;
		this.category = category;
		this.taskList = taskList;
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




	public List<TaskDomain> getTaskList() {
		return taskList;
	}




	public void setTaskList(List<TaskDomain> taskList) {
		this.taskList = taskList;
	}

	

}

