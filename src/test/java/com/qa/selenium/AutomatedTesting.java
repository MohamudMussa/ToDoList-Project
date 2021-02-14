package com.qa.selenium;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AutomatedTesting {

	
	
	private static WebElement targ;
	
    private static WebDriver driver;
    
    //TODO WEBSITE
    private static String URL = "http://localhost:8080/";

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();

    }

//    @Test
//    public void ToDoListLoads() throws InterruptedException {
//    	
//    	//GIVEN THAT I CAN ACCES MY TO DO WEBSITE
//        driver.get(URL);
    
    //LOGO TEST
    
//        
// 
//        //ASSERTION 
//        
//        assertEquals("ToDolist by Mohamud Mussa", driver.getTitle());
//        Thread.sleep(9000); // do not use
//    }
//    
    
    @Test
    public void createATask() throws InterruptedException {
    	
    	//GIVEN: That I can access the website
       
    	driver.get(URL);
        
        //WHEN: I click on create task button on my index page 
        
        targ = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/button[1]"));
        targ.click();
        
        element.getAttribute("src");
        
  

        
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
        String result = driver.getTitle();
    
        //ASSERTION 
        
        assertEquals("ToDolist by Mohamud Mussa", result);
        
        //change sleep to wait
        Thread.sleep(9000); // do not use
    }


    @AfterAll
    public static void tearDown() {
        driver.close();
    }
    
	public static ChromeOptions chromeCfg() {
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 ChromeOptions cOptions = new ChromeOptions();
		  
		 prefs.put("profile.default_content_setting_values.cookies", 2);
		 prefs.put("network.cookie.cookieBehavior", 2);
		 prefs.put("profile.block_third_party_cookies", true);

		 cOptions.setExperimentalOption("prefs", prefs);

		 return cOptions;
		 }
    
    
}