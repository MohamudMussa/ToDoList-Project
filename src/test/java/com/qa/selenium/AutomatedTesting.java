package com.qa.selenium;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;


public class AutomatedTesting {

	
	
	private static WebElement targ;
	
    private static WebDriver driver;
    
    IndexPage website = PageFactory.initElements(driver, IndexPage.class);
    AddList addList = PageFactory.initElements(driver, AddList.class);
    
    //TODO WEBSITE
    private static String URL = "http://localhost:8080/";

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", 
        		"src/main/resources/drivers/chrome/chromedriver.exe");

        
        ChromeOptions config = new ChromeOptions();
        config.setHeadless(true);
        
        
        driver = new ChromeDriver(config);

    }

    @Test
    public void urlLoads() throws InterruptedException {
    	
    	//GIVEN THAT I CAN ACCES MY TO DO WEBSITE
        driver.get(URL);
        
        // THEN I GET MY TITLE
        
        //"ToDolist by Mohamud Mussa"
 
        //ASSERTION 
        
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
////        Boolean resultTrue = targ;
//        Boolean expected = true;
//   
//        
//        assertEquals(expected, targ);
//    }
    
    
    
    @Test
    public void createATask() throws InterruptedException {
    	
    	//GIVEN: That I can access the website
       
    	driver.get(URL);
    	        
        //WHEN: I click on create task button on my index page 
        
        website.addTaskButton();
        
        // THEN I WANT TO CHECK THE INITAL COUNT OF MY TO DO LIST
        int initalcount = driver.findElements(By.xpath("//*[@id=\"taskID\"]/p")).size();
        
        // THEN: I should get input options
        
        targ = driver.findElement(By.id("taskinput"));
        targ.sendKeys("New Task");
        
        targ = driver.findElement(By.id("categoryInput"));
        targ.sendKeys("New Category");
       
        targ = driver.findElement(By.id("rankInput"));
        targ.sendKeys("2");
        
        targ = driver.findElement(By.id("completedInput"));
        targ.sendKeys("false");
        
        targ = driver.findElement(By.id("listValue"));
        targ.sendKeys("1");
        
        
        // AND: Then I click on create task button
        targ = driver.findElement(By.xpath("//*[@id=\"createMethod\"]/div/div/div[3]/button[1]"));
        targ.click();
        
        
        //THEN: I should be able to see a new task in my list
        
        
        int expectedCount = driver.findElements(By.xpath("//*[@id=\"taskID\"]/p")).size();

        int result = initalcount + 1;
        
        //ASSERTION 
		
        assertEquals(expectedCount, result);
        

    }

    
    
    //CREATE A NEW LIST ITEM
    @Test
    public void createAList() throws InterruptedException {
    	
    	//GIVEN: That I can access the website
       
    	driver.get(URL);
    	        
        //WHEN: I click on create list button on my index page 
        
        website.addListButton();
        
        // THEN I WANT TO CHECK THE INITAL COUNT OF MY TO DO LIST
        
        int initalListCount = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();
        
        
        // THEN: I create a LIST using information
        
        addList.createList("List Test Name");
        
        
        //THEN: I should be able to see a new List in my list
        
        
        int expectedList = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();
        
        int resultList = initalListCount + 1;
        
 
        //ASSERTION 
		
        assertEquals(expectedList, resultList);
        

    }
    
    
    //UPDATE A NEW LIST ITEM
    @Test
    public void updateLIST() throws InterruptedException {
    	
    	//GIVEN: That I can access the website
    	
       
    	driver.get(URL);
    	        
        //WHEN: I click on create list button on my index page 
        
        website.updateListButton();
        
        // THEN I WANT TO CHECK THE INITAL VALUE ITEM LIST NAME AT ID 1 IS "Helping"
        
        WebElement targ = driver.findElement(By.xpath("//*[@id=\"ListName\"]/p[1]"));
        targ.getText();
        
        // THEN: I create a LIST using information
     
        addList.updateList("1", "Help");
        
        String expected = "Help";
        
        //THEN: I should be able to see a new up to date List name

        WebElement targtwo = driver.findElement(By.xpath("//*[@id=\"ListName\"]/p[1]"));

        String newValue = targtwo.getText(); //"Work"
        
        
        //ASSERTION
        assertEquals(expected, newValue);
               

    }

    
    //UPDATE A NEW LIST ITEM
    @Test
    public void deletList() throws InterruptedException {
    	
    	//GIVEN: That I can access the website
    	
       
    	driver.get(URL);
    	        
        //WHEN: I click on create list button on my index page 
        
        website.deleteListButton();
        
        // THEN I WANT TO CHECK THE INITAL VALUE AMOUNT OF LIST ITEMS
 
        int deleteInitalCount = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();

        
        // THEN: I create a LIST using information
     
        addList.delteList("5");
        
        
        //THEN: I should be able to see a new up to date List name
        
        int deleteAfterCount = driver.findElements(By.xpath("//*[@id=\"todoID\"]/p")).size();


        int deleteResults = deleteInitalCount - 1;

        
        //ASSERTION
        
        assertEquals(deleteAfterCount, deleteResults);

       

    }
    
    
    
    

    @AfterAll
    public static void tearDown() {
        driver.close();
    }
    
    
}