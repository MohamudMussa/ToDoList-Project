package com.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoListTest {
	


	//LIST CREATE
	@FindBy(xpath = "//*[@id=\"createMethodLIST\"]/div/div/div[3]/button[1]")
	private WebElement submitListButton;
	
	@FindBy(xpath = "//*[@id=\"newListName\"]")
	private WebElement listName;
	
	
	//LIST UPDATE
	@FindBy(id = "updatedIDforList")
	private WebElement updateID;
	
	@FindBy(id = "updatedListNametxt")
	private WebElement updateListName;
	
	@FindBy(xpath = "//*[@id=\"updateMethodLIST\"]/div/div/div[3]/button[1]")
	private WebElement submitListUpdate;	
	
	
	
	//LIST DELETE
	@FindBy(id = "deleteListID")
	private WebElement deletID;
	
	@FindBy(xpath = "//*[@id=\"deleteMethodLIST\"]/div/div/div[3]/button[1]")
	private WebElement deleteIDButton;

	
	
		
	

	public ToDoListTest(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	public void createList(String listName) {
		
		this.listName.sendKeys(listName);
		this.submitListButton.click();
		
	}
	
	public void updateList(String ID,String newListName) {
		
		
		this.updateID.sendKeys(ID);
		this.updateListName.sendKeys(newListName);
		this.submitListUpdate.click();
		
	}
	
	
	public void delteList(String ID) {
		
		
		this.deletID.sendKeys(ID);
		this.deleteIDButton.click();
		
	}
	
}



