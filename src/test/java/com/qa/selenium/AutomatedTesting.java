package com.qa.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class AutomatedTesting {

	private static WebElement targ;

	private static WebDriver driver;
	
	private static ExtentReports report;
	
	private static ExtentTest test;
	
	IndexPage website = PageFactory.initElements(driver, IndexPage.class);
	ToDoListTest ToDoListTest = PageFactory.initElements(driver, ToDoListTest.class);
	ToDoTaskTest ToDoTaskTest = PageFactory.initElements(driver, ToDoTaskTest.class);


	// TODO WEBSITE
	private static String URL = "http://localhost:8080/";

	@BeforeAll
	public static void setup() {
		
		
		//extent report
		report = new ExtentReports("target/reports/ToDoListReport.html", true);
		
		//driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver.exe");

		ChromeOptions config = new ChromeOptions();
		
		//hides chrome
		config.setHeadless(true);

		driver = new ChromeDriver(config);
	

	}
	
	@AfterEach
	public void endTest() {
		//end report after each test
		report.endTest(test);
	
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

	//READ TASK
    @Test
    public void readAllTasks() throws InterruptedException {
    	
    	test = report.startTest("READ TASK TEST");
    	
    	//GIVEN THAT I CAN ACCES MY TO DO WEBSITE
        driver.get(URL);
        
        
        //WHEN THE WEBSITE LOADS UP
        
		Integer current = driver.findElements(By.xpath("//*[@id=\"taskID\"]/p")).size();

        
        //THEN I SHOULD BE ABLE TO SEE MY TASKS
       
        Integer expected = current;
        
        // ASSERTION
		
		
		if(expected.equals(current)) {
			test.log(LogStatus.PASS, "Tasks have loaded");
		} else {
			test.log(LogStatus.FAIL, "tasks have not loaded");
		}
		
		assertEquals(expected, current);
    }
    
    
	//READ LIST
    @Test
    public void readAllList() throws InterruptedException {
    	
    	test = report.startTest("READ LIST TEST");
    	
    	//GIVEN THAT I CAN ACCES MY TO DO WEBSITE
        driver.get(URL);
        
        
        //WHEN THE WEBSITE LOADS UP
        
		Integer current = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

        
        //THEN I SHOULD BE ABLE TO SEE MY TASKS
       
        Integer expected = current;
        
        // ASSERTION
		
		
		if(expected.equals(current)) {
			test.log(LogStatus.PASS, "Lists have loaded");
		} else {
			test.log(LogStatus.FAIL, "List have not loaded");
		}
		
		assertEquals(expected, current);
    }


	
	//CREATE TASK TEST
	@Test
	public void createATask() throws InterruptedException {
		
		test = report.startTest("CREATE TASK TEST");

		// GIVEN: That I can access the website

		driver.get(URL);

		// WHEN: I click on create task button on my index page

		website.addTaskButton();

		// THEN I WANT TO CHECK THE INITAL COUNT OF MY TO DO LIST
		Integer initalcount = driver.findElements(By.xpath("//*[@id=\"taskID\"]/p")).size();

		// THEN: I should get input options AND click on the create button
		ToDoTaskTest.createTask("A New Task", "Shopping", "2", "false", "1");	

		// THEN: I should be able to see a new task in my list

		Integer expectedCount = driver.findElements(By.xpath("//*[@id=\"taskID\"]/p")).size();

		Integer result = initalcount + 1;

		// ASSERTION
		
		
		if(result.equals(expectedCount)) {
			test.log(LogStatus.PASS, "Task Was Created");
		} else {
			test.log(LogStatus.FAIL, "user was not created");
		}
		
		assertEquals(expectedCount, result);
		
		

	}

	//UPDATE TASK
	@Test
	public void updateTask() throws InterruptedException {
		
		//report name
		test = report.startTest("UPDATE TASK TEST");

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
		
		if(expectedUpdateTask.equals(newValue)) {
			test.log(LogStatus.PASS, "Task Was Updated");
		} else {
			test.log(LogStatus.FAIL, "user was not Updated");
		}

		// ASSERTION
		assertEquals(expectedUpdateTask, newValue);

	}
	
	
	//DELETE A TASK
	@Test
	public void deleteTask() throws InterruptedException {
		
		//report name
		test = report.startTest("DELETE TASK TEST");


		
		// GIVEN: That I can access the website

		driver.get(URL);
		
		// THEN I WANT TO CHECK THE INITAL VALUE AMOUNT OF LIST ITEMS

		Integer deleteTaskBefore = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		// WHEN: I click on create list button on my index page

		website.deleteTaskButton();

		// THEN: I create a LIST using information

		ToDoTaskTest.delteTask("5");

		// THEN: I should be able to see a new up to date List name

		Integer taskdeleteAfter = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		
		int deleteResults = (deleteTaskBefore - 1);

		// ASSERTION
		
		if(deleteTaskBefore.equals(deleteResults)) {
			test.log(LogStatus.PASS, "User was deleted");
		} else {
			test.log(LogStatus.FAIL, "user was not Updated");
		}

		assertEquals(taskdeleteAfter, deleteResults);


	}
	
	
	
	
	// CREATE A NEW LIST ITEM
	@Test
	public void createAList() throws InterruptedException {
		
		test = report.startTest("CREATE LIST TEST");

		// GIVEN: That I can access the website

		driver.get(URL);

		// WHEN: I click on create list button on my index page

		website.addListButton();

		// THEN I WANT TO CHECK THE INITAL COUNT OF MY TO DO LIST

		Integer initalListCount = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		// THEN: I create a LIST using information

		ToDoListTest.createList("List Test Name");

		// THEN: I should be able to see a new List in my list

		Integer expectedList = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		Integer resultList = initalListCount + 1;

		// ASSERTION
		
		if(expectedList.equals(resultList)) {
			test.log(LogStatus.PASS, "User was deleted");
		} else {
			test.log(LogStatus.FAIL, "user was not Updated");
		}

		assertEquals(expectedList, resultList);

	}

	// UPDATE A NEW LIST ITEM
	@Test
	public void updateLIST() throws InterruptedException {
		
		test = report.startTest("UPDATE LIST TEST");

		// GIVEN: That I can access the website

		driver.get(URL);

		// WHEN: I click on create list button on my index page
		
		website.updateListButton();
		
		// THEN: I create a LIST using information

		ToDoListTest.updateList("1", "UPDATE TEST");

		String expected = "UPDATE TEST";

		// THEN: I should be able to see a new up to date List name

		WebElement targtwo = driver.findElement(By.xpath("//*[@id=\"ListName\"]/p[1]"));
		
		String newValue = targtwo.getText(); // "UPDATE TEST""
		
		if(expected.equals(newValue)) {
			test.log(LogStatus.PASS, "User was deleted");
		} else {
			test.log(LogStatus.FAIL, "user was not Updated");
		}
		

		// ASSERTION
		assertEquals(expected, newValue);

	}

	// DELETE A NEW LIST ITEM
	@Test
	public void deletList() throws InterruptedException {
		
		test = report.startTest("DELETE LIST TEST");

		// GIVEN: That I can access the website

		driver.get(URL);
		
		// THEN I WANT TO CHECK THE INITAL VALUE AMOUNT OF LIST ITEMS

		Integer deleteInitalCount = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

		// WHEN: I click on create list button on my index page

		website.deleteListButton();


		// THEN: I create a LIST using information

		ToDoListTest.delteList("2");

		// THEN: I should be able to see a new up to date List name

	
		
		Integer deleteResults = deleteInitalCount - 1;

		Integer aftercount = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();
		
		// ASSERTION

		if(aftercount.equals(deleteResults)) {
			test.log(LogStatus.PASS, "User was deleted");
		} else {
			test.log(LogStatus.FAIL, "user was not Updated");
		}
		
		assertEquals(aftercount, deleteResults);

	}
	

	@AfterAll
	public static void tearDown() {
		
		driver.close();
		
		//clean up extent report
		report.flush();
		report.close();
	
	}

}