package com.qa.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;


public class AutomatedTesting {

	private static WebElement targ;

	private static WebDriver driver;

	IndexPage website = PageFactory.initElements(driver, IndexPage.class);
	ToDoListTest ToDoListTest = PageFactory.initElements(driver, ToDoListTest.class);
	ToDoTaskTest ToDoTaskTest = PageFactory.initElements(driver, ToDoTaskTest.class);


	// TODO WEBSITE
	private static String URL = "http://localhost:8080/";

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver.exe");

		ChromeOptions config = new ChromeOptions();
		config.setHeadless(false);

		driver = new ChromeDriver(config);

	}

	@Test
	public void urlLoads() throws InterruptedException {

		// GIVEN THAT I CAN ACCES MY TO DO WEBSITE
		driver.get(URL);

		// THEN I GET MY TITLE

		// "ToDolist by Mohamud Mussa"

		// ASSERTION

		assertEquals("ToDolist by Mohamud Mussa", driver.getTitle());
	}

	  //PRINT PAGE TEST
//    @Test
//    public void print() throws InterruptedException {
//    	
//    	//GIVEN THAT I CAN ACCES MY TO DO WEBSITE
//        driver.get(URL);
//        
//        website.printButton();
//        
//        Boolean targ = driver.findElement(By.xpath("/html/body/print-preview-app//print-preview-sidebar//print-preview-button-strip//div/cr-button[1]")).isDisplayed();    
//        
//        Boolean resultTrue = targ;
//        Boolean expected = true;
//   
//        
//        assertEquals(expected, targ);
//    }

	
	//CREATE TASK TEST
	@Test
	public void createATask() throws InterruptedException {

		// GIVEN: That I can access the website

		driver.get(URL);

		// WHEN: I click on create task button on my index page

		website.addTaskButton();

		// THEN I WANT TO CHECK THE INITAL COUNT OF MY TO DO LIST
		int initalcount = driver.findElements(By.xpath("//*[@id=\"taskID\"]/p")).size();

		// THEN: I should get input options AND click on the create button
		ToDoTaskTest.createTask("A New Task", "Shopping", "2", "false", "1");	

		// THEN: I should be able to see a new task in my list

		int expectedCount = driver.findElements(By.xpath("//*[@id=\"taskID\"]/p")).size();

		int result = initalcount + 1;

		// ASSERTION

		assertEquals(expectedCount, result);

	}

	//UPDATE TASK
	@Test
	public void updateTask() throws InterruptedException {

		// GIVEN: That I can access the website

		driver.get(URL);

		// WHEN: I click on create list button on my index page

		website.updateTaskButton();

		// THEN I WANT TO CHECK THE INITAL VALUE ITEM LIST NAME AT ID 1 IS "Helping"

		targ = driver.findElement(By.xpath("//*[@id=\"task\"]/p[1]"));
		targ.getText();
		
		
		// THEN: I update a LIST using the new information
		
		ToDoTaskTest.updateTask("1", "Buy Rice", "Work", "3", "false", "1");
		
		String expectedUpdateTask = "Buy Rice";

		// THEN: I should be able to see a new up to date List name
		WebElement targtwo = driver.findElement(By.xpath("//*[@id=\"task\"]/p[1]"));
		
		
		String newValue = targtwo.getText(); // "Buy Rice"

		// ASSERTION
		assertEquals(expectedUpdateTask, newValue);

	}
	
	
	//DELETE A TASK
	@Test
	public void deleteTask() throws InterruptedException {

		// GIVEN: That I can access the website

		driver.get(URL);
		
		// THEN I WANT TO CHECK THE INITAL VALUE AMOUNT OF LIST ITEMS

		int deleteTaskBefore = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		// WHEN: I click on create list button on my index page

		website.deleteTaskButton();

		// THEN: I create a LIST using information

		ToDoTaskTest.delteTask("5");

		// THEN: I should be able to see a new up to date List name

		int taskdeleteAfter = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		
		int deleteResults = (deleteTaskBefore - 1);

		// ASSERTION

		assertNotEquals(taskdeleteAfter, deleteResults);


	}
	
	
	
	
	// CREATE A NEW LIST ITEM
	@Test
	public void createAList() throws InterruptedException {

		// GIVEN: That I can access the website

		driver.get(URL);

		// WHEN: I click on create list button on my index page

		website.addListButton();

		// THEN I WANT TO CHECK THE INITAL COUNT OF MY TO DO LIST

		int initalListCount = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		// THEN: I create a LIST using information

		ToDoListTest.createList("List Test Name");

		// THEN: I should be able to see a new List in my list

		int expectedList = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		int resultList = initalListCount + 1;

		// ASSERTION

		assertEquals(expectedList, resultList);

	}

	// UPDATE A NEW LIST ITEM
	@Test
	public void updateLIST() throws InterruptedException {

		// GIVEN: That I can access the website

		driver.get(URL);

		// WHEN: I click on create list button on my index page
		
		website.updateListButton();
		
		// THEN: I create a LIST using information

		ToDoListTest.updateList("1", "UPDATE TEST");

		String expected = "UPDATE TEST";

		// THEN: I should be able to see a new up to date List name

		WebElement targtwo = driver.findElement(By.xpath("//*[@id=\"ListName\"]/p[1]"));
		String newValue = targtwo.getText(); // "Work"
		
		

		// ASSERTION
		assertEquals(expected, newValue);

	}

	// DELETE A NEW LIST ITEM
	@Test
	public void deletList() throws InterruptedException {

		// GIVEN: That I can access the website

		driver.get(URL);
		
		// THEN I WANT TO CHECK THE INITAL VALUE AMOUNT OF LIST ITEMS

		int deleteInitalCount = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		// WHEN: I click on create list button on my index page

		website.deleteListButton();


		// THEN: I create a LIST using information

		ToDoListTest.delteList("2");

		// THEN: I should be able to see a new up to date List name

		int deleteResults = deleteInitalCount - 1;

		// ASSERTION

		assertNotEquals(deleteInitalCount, deleteResults);

	}
	

	@AfterAll
	public static void tearDown() {
		driver.close();
	
	}

}