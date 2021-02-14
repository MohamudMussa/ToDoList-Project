package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/button[1]")
	private WebElement addTask;

	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/button[2]")
	private WebElement updateTask;
	

	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/button[3]")
	private WebElement deleteTask;

	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/button[4]")
	private WebElement printPage;
	

	public IndexPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addTaskButton() {
		
		addTask.click();

	}

	public void updateTaskButton() {
		
		updateTask.click();

	}

	public void deleteTaskButton() {

	}

	public void printButton() {
		printPage.click();

	}
}
