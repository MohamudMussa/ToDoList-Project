package com.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoTaskTest {
	


	//Task CREATE
	@FindBy(xpath = "//*[@id=\"createMethod\"]/div/div/div[3]/button[1]")
	private WebElement submitTaskButton;
	
	@FindBy(id = "taskinput")
	private WebElement taskName;
	
	@FindBy(id = "categoryInput")
	private WebElement category;
	
	@FindBy(id = "rankInput")
	private WebElement rank;
	
	@FindBy(id = "completedInput")
	private WebElement completed;
	
	@FindBy(id = "listValue")
	private WebElement connectedList;
	
	
	//Task UPDATE
	@FindBy(xpath = "//*[@id=\"updateMethod\"]/div/div/div[3]/button[1]")
	private WebElement submitUpdateButton;
	
	@FindBy(id = "updateID")
	private WebElement updatedTaskID;
	
	@FindBy(id = "updateTask")
	private WebElement updateName;
	
	@FindBy(id = "updateCategory")
	private WebElement updateCategory;
	
	@FindBy(id = "updateRank")
	private WebElement updateRank;
	
	@FindBy(id = "updateCompleted")
	private WebElement updateCompleted;
	
	@FindBy(id = "updateTodoList")
	private WebElement updateConnectedList;
	
	
	//Task DELETE
	@FindBy(xpath = "//*[@id=\"deleteMethod\"]/div/div/div[3]/button[1]")
	private WebElement submitDeleteButton;
	
		
	@FindBy(id = "deleteID")
	private WebElement DeleteTaskID;
	
	
	
	
	
	//Task UPDATE
	@FindBy(id = "updatedIDforTask")
	private WebElement updateID;
	
	@FindBy(id = "updatedTaskNametxt")
	private WebElement updateTaskName;
	
	@FindBy(xpath = "//*[@id=\"updateMethodTask\"]/div/div/div[3]/button[1]")
	private WebElement submitTaskUpdate;	
	
	
	
	//Task DELETE
	@FindBy(id = "deleteID")
	private WebElement deletID;
	
	@FindBy(xpath = "//*[@id=\"deleteMethod\"]/div/div/div[3]/button[1]")
	private WebElement deleteIDButton;

	
	
		
	

	public ToDoTaskTest(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	//CREATE TASK
	public void createTask(String taskName, String category, String rank, String completed, String connectedList) {
		
		this.taskName.sendKeys(taskName);
		this.category.sendKeys(category);
		this.rank.sendKeys(rank);
		this.completed.sendKeys(completed);
		this.connectedList.sendKeys(connectedList);
			
		this.submitTaskButton.click();
		
	}
	
	//UPDATE TASK
	public void updateTask(String ID, String taskName, String category, String rank, String completed, String connectedList) {
		
		this.updatedTaskID.sendKeys(ID);
		this.updateName.sendKeys(taskName);
		this.updateCategory.sendKeys(category);
		this.updateRank.sendKeys(rank);
		this.updateCompleted.sendKeys(completed);
		this.updateConnectedList.sendKeys(connectedList);
			
		this.submitUpdateButton.click();
		
	}
	
	

	
	
	//UPDATE TASK
	public void updateTask(String ID,String newTaskName) {
		
		this.updateID.sendKeys(ID);
		this.updateTaskName.sendKeys(newTaskName);
		this.submitTaskUpdate.click();
		
	}
	
	
	//DELETE TASK
	public void delteTask(String ID) {
		
		
		this.deletID.sendKeys(ID);
		this.deleteIDButton.click();
		
	}
	
}



