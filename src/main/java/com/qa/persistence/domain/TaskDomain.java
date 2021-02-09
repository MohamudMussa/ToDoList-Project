package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.sun.istack.NotNull;

@Entity
public class TaskDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String category;

	@NotNull
	private Integer rank;

	@NotNull
	private Boolean completed;

	@ManyToOne
	private ToDoDomain myToDo;

	public TaskDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskDomain(Long id, String name, String category, Integer rank, Boolean completed, ToDoDomain myToDo) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.rank = rank;
		this.completed = completed;
		this.myToDo = myToDo;

	}

	public TaskDomain(String name, String category, Integer rank, Boolean completed, ToDoDomain myToDo) {
		super();
		this.name = name;
		this.category = category;
		this.rank = rank;
		this.completed = completed;
		this.myToDo = myToDo;

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

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public ToDoDomain getMyToDo() {
		return myToDo;
	}

	public void setMyToDo(ToDoDomain myToDo) {

		this.myToDo = myToDo;
	}

}