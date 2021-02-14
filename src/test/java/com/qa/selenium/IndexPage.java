package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

	
	//TASK INITAL BUTTONS
	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/button[1]")
	private WebElement addTask;
	

	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/button[2]")
	private WebElement updateTask;
	

	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/button[3]")
	private WebElement deleteTask;

	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/button[4]")
	private WebElement printPage;
	
	
	
	
	//ITEM INITAL BUTTONS
	@FindBy(xpath = "//*[@id=\"main\"]/div[7]/button[1]")
	private WebElement addList;

	@FindBy(xpath = "//*[@id=\"main\"]/div[7]/button[2]")
	private WebElement updateList;
	

	@FindBy(xpath = "//*[@id=\"main\"]/div[7]/button[3]")
	private WebElement deleteList;


    
    
	

	public IndexPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//list
	public void addListButton() {
		addList.click();

	}

	public void updateListButton() {
		
		updateList.click();

	}

	public void deleteListButton() {
		
		deleteList.click();
	}


	//task crud
	
	public void addTaskButton() {
		
		addTask.click();

	}

	public void updateTaskButton() {
		
		updateTask.click();

	}

	public void deleteTaskButton() {
		deleteTask.click();

	}

	public void printButton() {
		printPage.click();

	}
}
